const jwt = require("jsonwebtoken")
const User = require("../models/Users")

const verifyToken = async (req,res,next) =>{
    const token  = req.header("auth-token");
    if (!token) return res.status(401).json({
        error: "Access denied"
    });

    try{
        const verified = jwt.verify(token, process.env.TOKEN_SECRET);
        req.user = verified;
        
        let myUser = await User.findById(req.user.id)
        req.user = myUser;
      
        next();
    }catch(err){
        res.status(400).json({error: "Token is not valid"});
    }
};

module.exports = verifyToken;