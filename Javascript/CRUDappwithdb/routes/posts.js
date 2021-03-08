const express = require('express');


const Post = require("../models/Posts")
const User = require("../models/Users")

const router  = express.Router()

//GET ALL POST

router.get("/", async (req, res  )=>{
    console.log(req.user._id)
    
    try{
    const posts = await Post.find({"author": req.user});
   
    res.json(posts);

    }catch(err){
        
        res.status(400).json({msg:err})
    }
    
});
//GET POST BY ID

router.get("/:id",async (req, res  )=>{   
    
    try{
        const post = await  Post.findById(req.params.id);
        res.json(post);
    }catch(err){
        res.json({msg:err})
    }
   
});


// CREATE POST
router.post("/", (req, res  )=>{
    
    
    const newPost = new Post({
        title: req.body.title,
        description: req.body.description,
        author: req.user._id,
    });
   

    newPost.save()
    .then(data =>{
       
        req.user.posts.push(newPost)

        req.user.save()
        .then(d =>{
            res.json({data,"msg": "user updated"});
        })
       
    })
    .catch(err=>{
        console.log(err)
    })
    
    
   
});

// UPDATE POST

router.put("/:id",async (req, res  )=>{  
    
    try{
        const updatedPost = await  Post.updateOne(
            {_id:req.params.id},
            {$set:req.body, }
            );
        res.json(updatedPost);
    }catch(err){
        res.json({msg:err})
    }
   
});


// DELETE POST

router.delete("/:id",async (req, res  )=>{

    try{
        const post = await Post.findById(req.params.id);
    }catch(err){
        res.status(404).json("Post Id not valid");
    }
    
    
    try{
        const myUser = await User.updateOne(
            {_id : req.user._id},
            { $pull: { posts:  req.params.id } },
            { multi: true }
        );  

        const removedPost = await  Post.findByIdAndDelete(req.params.id);
        
            
       
        res.json({"msg": "user updated", removedPost});       


        
    }catch(err){
        console.log(err)
        res.json({msg:err})
    }
   
});

module.exports = router;
