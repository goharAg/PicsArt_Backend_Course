const express = require('express');
const multer = require('multer')
const Post = require("../models/Posts")
const User = require("../models/Users")

const router  = express.Router()

const upload = multer();

//GET ALL POST

router.get("/", async (req, res  )=>{
        
    try{
    const posts = await Post.find({"author": req.user});
   
    res.json(posts);

    }catch(err){
        
        res.status(400).json({msg:err})
    }
    
});

//GET Recent Post

router.get("/recent",async (req, res  )=>{   
    
    try{
        const post = await  Post.findOne({}).sort({date: -1});
        if(!post){
            res.status(404).json("not found");
        }else{
        res.status(404).json(post);
        }
    }catch(err){
        res.status(404).json({msg:err})
    }
   
});
//GET POST BY ID

router.get("/:id",async (req, res  )=>{   
    
    try{
        const post = await  Post.findById(req.params.id);
        res.status(200).json(post);
    }catch(err){
        res.status(404).json({msg:err})
    }
   
});

//GET POST'S PHOTO

router.get("/:id/photo",async (req, res  )=>{   
    
    try{
        const post = await  Post.findById(req.params.id);
        if(post.photo) {  
            res.set('Content-Type', 'image/jpg; charset=UTF-8');
            res.status(200).sendFile(post.photo);
        }
        else{ res.status(404).json({"msg":"Photo not found"})  }
       
    }catch(err){
        res.status(404).json({msg:err})
    }
   
});


// CREATE POST
router.post("/",upload.single('photo'), (req, res  )=>{
    let file;
    if(req.file){
        file = req.file.buffer;
    }
    
    const newPost = new Post({
        title: req.body.title,
        description: req.body.description,
        author: req.user._id,
        photo:file,
    });
   

    newPost.save()
    .then(data =>{
       
        req.user.posts.push(newPost)

        req.user.save()
        .then(d =>{
            res.status(201).json({data,"msg": "user updated, post created"});
        }).catch(err =>{
            console.log(err)
            res.status(404).json({"msg":err})
        })
       
    })
    .catch(err=>{
        console.log(err)
        res.status(404).json({"msg":err})
    })
    
    
   
});

//ADD POST'S PHOTO

router.post("/:id/photo",upload.single('photo'),async (req, res  )=>{   
    
    try{
        const post = await  Post.findById(req.params.id);
        try{
            post.photo = req.file.buffer;
            await post.save();
            res.status(201).json(post);
        }catch(err){
            res.status(400).json({msg:err});
        }
       
    }catch(err){
        res.status(404).json({msg:err})
    }
   
});

// UPDATE POST

router.put("/:id",async (req, res  )=>{  
    
    try{
        const updatedPost = await  Post.updateOne(
            {_id:req.params.id},
            {$set:req.body, }
            );
        res.status(200).json(updatedPost);
    }catch(err){
        res.status(404).json({msg:err})
    }
   
});

//DELETE POST'S PHOTO

router.delete("/:id/photo",async (req, res  )=>{   
    
    try{
        const post = await  Post.findById(req.params.id);
        if(post.photo) {  
            post.photo = undefined;
            res.status(200).json(post);
        }
        else{ res.status(404).json({"msg":"Photo not found"})  }
       
    }catch(err){
        res.status(404).json({msg:err})
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
        
            
       
        res.status(200).json({"msg": "user updated", removedPost});       


        
    }catch(err){
        console.log(err)
        res.status(404).json({msg:err})
    }
   
});

module.exports = router;
