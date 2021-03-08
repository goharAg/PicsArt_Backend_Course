const router = require("express").Router();
const Post = require("../models/Posts")
const User = require("../models/Users")


// GET MY INFO
router.get("/myInfo", async (req,res)=>{  
    console.log("searching my Info")
    res.status(200).json(req.user);  
});

//UPDATE MY INFO

router.put("/edit", async (req,res)=>{
    try{
     
        const updatedUser = await  User.updateOne(
            {_id:req.user._id},
            {$set: req.body, }
            );
        
        res.status(200).json(updatedUser);
    }catch(err){
        res.status(404).json({msg:err})
    }

});


//GET USER BY ID
router.get("/:id", async (req,res)=>{
    try{
        const user = await User.findById(req.params.id);
        res.status(200).json(user);
    }catch(err){
        res.status(404).json({"msg" : "Id not found"});
    }

});

// GET USER'S POSTS
router.get("/:id/posts", async (req,res)=>{
    try{
        const user = await User.findById(req.params.id).populate('posts');
        
        res.status(200).json(user.posts);
    }catch(err){
        console.log(err)
        res.status(404).json({"msg" : err});
    }

});






module.exports = router;