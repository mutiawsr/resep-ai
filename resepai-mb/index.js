const express = require("express")
const app = express()
const mysql = require("mysql")
const bcrypt = require("bcrypt")
const getToken = require("./getToken")

require("dotenv").config()

const db = mysql.createPool({
   connectionLimit: 100,
   host: process.env.DB_HOST,
   user: process.env.DB_USER,
   password: process.env.DB_PASSWORD,
   database: process.env.DB_DATABASE,
   port: process.env.DB_PORT

})

app.use(express.json())
//middleware to read req.body.<params>

//Register
app.post("/regis", async (req,res) => {
const username = req.body.name;
const hashedPassword = await bcrypt.hash(req.body.password,10);
const no_hp = req.body.notlp;
const alamat = req.body.alamat;

db.getConnection( async (err, connection) => {
 if (err) throw (err)
 const sqlSearch = "SELECT * FROM usertb WHERE username = ?"
 const search_query = mysql.format(sqlSearch,[username])

 const sqlInsert = "INSERT INTO usertb VALUES (0,?,?,?,?)"
 const insert_query = mysql.format(sqlInsert,[username, hashedPassword, no_hp, alamat])
 // ? will be replaced by values
 // ?? will be replaced by string
 await connection.query (search_query, async (err, result) => {

  if (err) throw (err)
  console.log("------> Search Results")
  console.log(result.length)

  if (result.length != 0) {
   connection.release()
   console.log("------> User already exists")
   res.send(
      JSON.stringify({
        status: 409,
        response: result
      })
    );
  } 
  else {
   await connection.query (insert_query, (err, result)=> {
   connection.release()
   if (err) throw (err)
   console.log ("--------> Created new User")
   console.log(result.insertId)
   res.send(
      JSON.stringify({
        status: 200,
        response: result
      })
    );
  })
 }
}) //end of connection.query()
}) //end of db.getConnection()
}) //end of app.post()

//Login Auth
app.post("/login", (req, res)=> {
   const username = req.body.name
   const password = req.body.password

   db.getConnection ( async (err, connection)=> {
    if (err) throw (err)
    const sqlSearch = "Select * from usertb where username = ?"
    const search_query = mysql.format(sqlSearch,[username])

    await connection.query (search_query, async (err, result) => {
     connection.release()
     
     if (err) throw (err)
     if (result.length == 0) {
      console.log("--------> Username does not exist")
      res.send(
      JSON.stringify({
        status: 404,
        response: result
      })
    );
     } 
     else {
       const hashedPassword = result[0].password
        //get the hashedPassword from result
     if (await bcrypt.compare(password, hashedPassword)) {
       console.log("---------> Login Successful")
       console.log("---------> Generating accessToken")
       const token = getToken({username: username})   
       console.log(token)
       res.JSON({accessToken: token})
       res.send(`${username} is logged in!`)
       } 
       else {
       console.log("---------> Password Incorrect")
       res.send("Password incorrect!")
       } //end of bcrypt.compare()
     }//end of User exists i.e. results.length==0
    }) //end of connection.query()
   }) //end of db.connection()
}) //end of app.post()

// GET all Account 
app.get("/account", async (req,res) => {

   db.getConnection( async (err, connection) => {
    if (err) throw (err)
    const sqlSearch = "SELECT * FROM usertb"
    await connection.query (sqlSearch, async (err, result) => {
      connection.release()
     if (err) throw (err)
     console.log("------> hasil")
     res.send(JSON.stringify(
        { status: 200, 
          response: result 
         })); 
      }) //end of db.getConnection()
   })
}) //end of app.get()

app.get("/account/:id", async (req,res) => {
  const userId = req.params.userId

  db.getConnection( async (err, connection) => {
   if (err) throw (err)
   const sqlSearch = "SELECT * FROM usertb WHERE userId = ?"
   const search_query = mysql.format(sqlSearch,[userId])
   await connection.query (search_query, async (err, result) => {
     connection.release()
    if (err) throw (err)
    console.log("------> hasil")
    res.send(JSON.stringify(
       { status: 200, 
         response: result 
        })); 
     }) //end of db.getConnection()
  })
}) //end of app.get()

const port = process.env.PORT
app.listen(port, () => {
console.log(`Server Started on port ${port}...`)
}
)