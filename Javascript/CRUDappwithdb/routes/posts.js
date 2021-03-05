const express = require('express');

const Post = require("../models/Posts")

const router  = express.Router()

router.get("/", (req, res  )=>{
    const posts = Post.find();

    posts.then(data=>{
        res.json(data);
    })
    .catch(err=>{
        res.json({msg:err})
    })
    
});

router.get("/:id",async (req, res  )=>{
    
    
    try{
        const post = await  Post.findById(req.params.id);
        res.json(post);
    }catch(err){
        res.json({msg:err})
    }
   
});

router.post("/", (req, res  )=>{
    const newPost = new Post({
        title: req.body.title,
        description: req.body.description
    });
    console.log(newPost)

    newPost.save()
    .then(data =>{
        res.json(data);
    })
    .catch(err=>{
        console.log(err)
    })
   
});

router.put("/:id",async (req, res  )=>{
    
    
    try{
        const updatedPost = await  Post.updateOne(
            {_id:req.params.id},
            {$set:{title:req.body.title}}
            );
        res.json(updatedPost);
    }catch(err){
        res.json({msg:err})
    }
   
});


router.delete("/:id",async (req, res  )=>{
    
    
    try{
        const removedPost = await  Post.remove({_id:req.params.id});
        res.json(removedPost);
    }catch(err){
        res.json({msg:err})
    }
   
});

module.exports = router;
