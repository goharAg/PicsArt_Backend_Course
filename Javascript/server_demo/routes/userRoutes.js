const express = require("express");
const uuid = require("uuid");

const router = express.Router();
const users = require("../models/users.js");



//Gets all users
router.get("/", (req, res) =>{
    res.status(200).json(users);
});


//Gets user by id
router.get("/id/:id", (req, res) =>{
    const found = users.some(user => user.id === req.params.id);

    if (found){
        res.status(200).json(users.filter(user=>user.id === req.params.id));
    }else{
        res.status(400).json({msg: `User of id ${req.params.id} not found`});    
    }
    
});

//Gets user by name
router.get("/name/:name", (req, res) =>{
    const found = users.some(user => user.name === req.params.name);

    if (found){
        res.status(200).json(users.filter(user=>user.name === req.params.name));
    }else{
        res.status(400).json({msg: `User with name ${req.params.name} not found`});    
    }
    
});

//Create a user

router.post("/", (req,res) =>{
    const newUser = {
        name: req.body.name,
        gmail: req.body.gmail,
        id : uuid.v4()  
    }

    if( !newUser.name || !newUser.gmail){
        return res.status(400).json({msg: `Please include mail and gmail`})
    }

    users.push(newUser);
    res.status(200).json(users);
    
});


//Update User
router.put("/id/:id", (req, res) =>{
    const found = users.some(user => user.id === req.params.id);

    if (found){
        const updUser = req.body;
        
     
        users.forEach(user => {
            if(user.id === req.params.id){
               user.name = updUser.name ? updUser.name : user.name;
               user.gmail = updUser.gmail ? updUser.gmail : user.gmail;
            
               res.status(200).json({msg: `User updated`, user});
            }
        });


    }else{
        res.status(400).json({msg: `User of id ${req.params.id} not found`});    
    }
    
});


//Delete specific user
router.delete("/id/:id", (req, res) =>{
    const found = users.some(user => user.id === req.params.id);

    if (found){
        res.status(200).json({msg: `User Deleted`, users : users.filter(user=>user.id !== parseInt(req.params.id))});
    }else{
        res.status(400).json({msg: `User of id ${req.params.id} not found`});    
    }
    
});



module.exports = router;