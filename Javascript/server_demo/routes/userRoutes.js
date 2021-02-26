const express = require("express");
const uuid = require("uuid");

const router = express.Router();
//const users = require("../models/users.js");
const filesServices = require("../services/filesServices.js");
const usersServices = require("../services/usersServices")



//Gets all users
router.get("/", (req, res) =>{
    res.status(200).json(usersServices.getAllUsers());
});


//Gets user by id
router.get("/:id", (req, res) =>{
    let userById = usersServices.getUserByID(req.params.id);
    if(!userById){
       return  res.status(400).json({msg: `User of id ${req.params.id} not found`});    
    }

    res.status(200).json(userById);

   
    
});



//Create a user

router.post("/", (req,res) =>{
    try{
        let newUsers = usersServices.addUser(req.body);
        res.status(201).json(newUsers);
    }catch(error){
        
        res.status(400).json({msg: `Please include mail and gmail`})
    }   
    
    
});


//Update User
router.put("/:id", (req, res) =>{
  let updatedUsers =usersServices.updateUser(req.params.id, req.body);
  if(updatedUsers){
   res.status(200).json({msg: `Users updated`,updatedUsers});
  }else{
   res.status(400).json({msg: `User of id ${req.params.id} not found`});   
  }
});


//Delete specific user
router.delete("/:id", (req, res) =>{
 let deletedUsers =  usersServices.deleteUser(req.params.id);

    if(deletedUsers){
        res.status(200).json({msg: `User Deleted`, deletedUsers });
    }
    else{

        res.status(400).json({msg: `User of id ${req.params.id} not found`});  
    }
});



module.exports = router;