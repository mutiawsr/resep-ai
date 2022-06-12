const express = require("express")
const app = express()
const mysql = require("mysql")
const bcrypt = require("bcrypt")
const Multer = require("multer")
const path = require("path")
const { Storage } = require("@google-cloud/storage");
const src = path.join(__dirname, "views");

require("dotenv").config()

const port = process.env.PORT
app.listen(port, () => {
console.log(`Server Started on port ${port}...`)
}
)

const db = mysql.createPool({
    connectionLimit: 100,
    user: process.env.DB_USER,
    password: process.env.DB_PASS,
    database: process.env.DB_NAME,
    socketPath: `/cloudsql/${process.env.INSTANCE_CONNECTION_NAME}`,
 })

app.use(express.static(src));

app.use(express.json())
//middleware to read req.body.<params>

app.get("/", async (req,res) => {
    res.json({status : "berhasil!!"});
})

const multer = Multer({
    storage: Multer.memoryStorage(),
    limits: {
      fileSize: 5 * 1024 * 1024, // No larger than 5mb, change as you need
    },
});

let projectId = "resepai"; // Get this from Google Cloud
let keyFilename = "keygcp.json"; // Get this from Google Cloud -> Credentials -> Service Accounts
const storage = new Storage({
    projectId,
    keyFilename,
  });

const bucket = storage.bucket("image-url"); // Get this from Google Cloud -> Storage
// Gets all files in the defined bucket
app.get("/v/upload", async (req, res) => {
  try {
    const [files] = await bucket.getFiles();
    res.send([files]);
    console.log("Success");
  } catch (error) {
    res.send("Error:" + error);
  }
});

// Streams file upload to Google Storage
app.post("/v/upload", multer.single("imgfile"), (req, res) => {
  console.log("Made it /upload");
  try {
    if (req.file) {
      console.log("File found, trying to upload...");
      const blob = bucket.file(req.file.originalname);
      const blobStream = blob.createWriteStream();

      blobStream.on("finish", () => {
        res.status(200).send("Success");
      });
      blobStream.end(req.file.buffer);
    } else throw "error with img";
  } catch (error) {
    res.status(500).send(error);
  }
});

// Get the main index html file
app.get("/", (req, res) => {
    res.sendFile(src + "/index.html");
});

// Table usertb
//Register account
app.post("/v/regis", async (req,res) => {
    const email = req.body.email;
    const username = req.body.username;
    const hashedPassword = await bcrypt.hash(req.body.password,10);
    const name = username;
    const no_hp = "";
    const alamat = "";
    const photourl = "https://storage.googleapis.com/image-url/profileimage.png";
    
    db.getConnection( async (err, connection) => {
     if (err) throw (err)
     const sql = "SELECT * FROM usertb WHERE username = ? OR email = ?";
     const search_query = mysql.format(sql,[username, email])
    
     const sqlInsert = "INSERT INTO usertb VALUES (0,?,?,?,?,?,?,?)"
     const insert_query = mysql.format(sqlInsert,[email, username, hashedPassword, name, no_hp, alamat, photourl])
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
        const sqlSearch = "Select * from usertb where email = ?";
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
           res.send(
             JSON.stringify({
              status: 200, 
              response: result 
             })
            );
          } 
           else {
           console.log("---------> Password Incorrect")
           res.send(JSON.stringify({
            status: 200, 
            response: result  
             })
            );
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
    
// GET account by username
app.get("/v/user/:username", async (req,res) => {
      const username = req.params.username
    
      db.getConnection( async (err, connection) => {
       if (err) throw (err)
       const sqlSearch = "SELECT * FROM usertb WHERE username = ?"
       const search_query = mysql.format(sqlSearch,[username])
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
      const username = req.body.username;
      const hashedPassword = await bcrypt.hash(req.body.password,10);
      const no_hp = req.body.no_hp;
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
// GET resep by kategori 
app.get("/v/resepkategori/:kategori", async (req,res) => {
      const kategori = req.params.kategori
    
      db.getConnection( async (err, connection) => {
       if (err) throw (err)
       const sqlSearch = "SELECT * FROM resep WHERE kategori = ?"
       const search_query = mysql.format(sqlSearch,[kategori])
    
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
})
    
// GET resep by keyword
app.get("/v/resep/:keyword", async (req,res) => {
      const keyword = req.params.keyword
    
      db.getConnection( async (err, connection) => {
       if (err) throw (err)
       const sqlSearch = "SELECT * FROM resep WHERE nama_resep LIKE '%" + keyword + "%'"
       const search_query = mysql.format(sqlSearch,[keyword])
    
       await connection.query (search_query, async (err, result) => {
         connection.release()
        if (err) throw (err)
          res.send(JSON.stringify(
            { status: 200, 
              response: result 
             }));
         }) //end of db.getConnection()
      })
})
    
// GET detail resep by id
app.get("/v/detailresep/:id", async (req,res) => {
      const id = req.params.id
    
      db.getConnection( async (err, connection) => {
       if (err) throw (err)
       const sqlSearch = "SELECT * FROM resep WHERE id = ?"
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
})
    
// GET most like resep
app.get("/v/reseplike", async (req,res) => {
    
      db.getConnection( async (err, connection) => {
        if (err) throw (err)
        const sqlSearch = "SELECT * FROM resep GROUP BY likes DESC LIMIT 10;"
    
        await connection.query (sqlSearch, async (err, result) => {
         connection.release()
         if (err) throw (err)
         res.send(JSON.stringify(
            { status: 200, 
              response: result 
             })); 
          }) 
       })
})
    
// Tabel Gabungan
// GET resep all kategori (kategoritb)
app.get("/v/detailbahan/:resepid", async (req,res) => {
      const resepid = req.params.resepid
    
      db.getConnection( async (err, connection) => {
        if (err) throw (err)
        const sqlSearch = "SELECT bahan.nama_bahan, bahan.harga FROM daftar_bahan INNER JOIN bahan ON daftar_bahan.id_bahan = bahan.id AND daftar_bahan.id_resep= ?"
        const search_query = mysql.format(sqlSearch,[resepid])
    
        await connection.query (search_query, async (err, result) => {
          connection.release()
         if (err) throw (err)
         res.send(JSON.stringify(
             {status: 200, 
              response: result 
             })); 
          }) 
       })
})




