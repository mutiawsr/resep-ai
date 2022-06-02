const jwt = require("jsonwebtoken")

function getToken (username) {
return 
jwt.sign(username, process.env.ACCESS_TOKEN_SECRET, {expiresIn: "15m"})
}
module.exports=getToken