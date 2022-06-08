const express = require("express")
const app = express()
const mysql = require("mysql")
const bcrypt = require("bcrypt")

require("dotenv").config()

const port = process.env.PORT
app.listen(port, () => {
console.log(`Server Started on port ${port}...`)
}
)

app.get("/", async (req,res) => {
    res.json({status : "berhasil!!"});
})

const db = mysql.createPool({
    connectionLimit: 100,
    host: process.env.DB_HOST,
    user: process.env.DB_USER,
    password: process.env.DB_PASS,
    database: process.env.DB_NAME,
 })

 app.use(express.json())
//middleware to read req.body.<params>

// Table usertb
//Register account
app.post("/v/regis", async (req,res) => {
const username = req.body.name;
const hashedPassword = await bcrypt.hash(req.body.password,10);
const no_hp = req.body.notlp;
const alamat = req.body.alamat;

db.getConnection( async (err, connection) => {
 if (err) throw (err)
 const sql = "SELECT * FROM usertb WHERE username = ?";
 const search_query = mysql.format(sql,[username])

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
})
}) 
}) //end of app.post()

//Login Auth
app.post("/v/login", (req, res)=> {
    const username = req.body.name
    const password = req.body.password

   db.getConnection ( async (err, connection)=> {
    if (err) throw (err)
    const sqlSearch = "Select * from usertb where username = ?";
    const search_query = mysql.format(sqlSearch,[username])

    await connection.query (search_query, async (err, result) => {
     connection.release()
     
     if (err) throw (err)
     if (result.length == 0) {
      console.log("--------> Username does not exist")
      res.send(
      JSON.stringify({
        status: 404,
        response: "Username Invalid!!"
      })
    );
     } 
     else {
       const hashedPassword = result[0].password
        //get the hashedPassword from result
     if (await bcrypt.compare(password, hashedPassword)) {
       console.log("---------> Login Successful")
       res.send(`${username} is logged in!`)
       } 
       else {
       console.log("---------> Password Incorrect")
       res.send("Password incorrect!")
       } 
     }
    }) 
   }) 
}) //end of app.post()

// GET all Account 
app.get("/v/account", async (req,res) => {

   db.getConnection( async (err, connection) => {
    if (err) throw (err)
    const sqlSearch = "SELECT * FROM usertb";
    await connection.query (sqlSearch, async (err, result) => {
      connection.release()
     if (err) throw (err)
     console.log("------> hasil")
     res.send(JSON.stringify(
        { status: 200, 
          response: result 
         })); 
      }) 
   })
}) //end of app.get()

// GET account by userid
app.get("/v/account/:id", async (req,res) => {
    const id = req.params.id

  db.getConnection( async (err, connection) => {
   if (err) throw (err)
   const sqlSearch = "SELECT * FROM usertb WHERE userid = ?"
   const search_query = mysql.format(sqlSearch,[id])
   await connection.query (search_query, async (err, result) => {
     connection.release()
    if (err) throw (err)
    console.log("------> Success")
    res.send(JSON.stringify(
       { status: 200, 
         response: result 
        })); 
     }) //end of db.getConnection()
  })
}) //end of app.get()

// UPDATE account
app.put("/v/account/:id", async (req,res) => {
  const id = req.params.id;
  const username = req.body.name;
  const hashedPassword = await bcrypt.hash(req.body.password,10);
  const no_hp = req.body.notlp;
  const alamat = req.body.alamat;

  db.getConnection( async (err, connection) => {
    if (err) throw (err)

    const sqlUpdate = "UPDATE usertb SET username = ?, password = ?, no_hp = ?, alamat = ? WHERE userid = ?";
    const update_query = mysql.format(sqlUpdate, [username, hashedPassword, no_hp, alamat, id])

    await connection.query (update_query, async (err, result) => {
      if (err) throw (err)
      connection.release()
      console.log("------> Updated Successful")
       res.send(
          JSON.stringify({
            status: 200,
            response: result
          })
        );
      })
   }) 
}) //end of app.put()

// DELETE account
app.delete("/v/account/:id", async (req,res) => {
  const id = req.params.id;

db.getConnection( async (err, connection) => {
 if (err) throw (err)
 const sqlSearch = "DELETE FROM usertb WHERE userid = ?";
 const search_query = mysql.format(sqlSearch,[id])
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


// Table resep
// GET resep by id 
app.get("/v/resepai/:id", async (req,res) => {

})

// 
app.get("/v/resepai", async (req,res) => {

  db.getConnection( async (err, connection) => {
    if (err) throw (err)
    const sqlSearch = "SELECT * FROM resep";
    await connection.query (sqlSearch, async (err, result) => {
      connection.release()
     if (err) throw (err)
     console.log("------> hasil")
     res.send(JSON.stringify(
        { status: 200, 
          response: result 
         })); 
      }) 
   })
})

