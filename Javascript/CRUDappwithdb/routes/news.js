const router = require("express").Router();
const Post = require("../models/Posts")
const User = require("../models/Users")

router.get("/", async(req,res) =>{
    try{
        const posts = await Post.find().select({"_id":0, "author":0});
       
        res.json(posts);
    
        }catch(err){
            console.log(err)
            res.status(400).json({msg:err})
        }
  
    
});

module.exports = router;