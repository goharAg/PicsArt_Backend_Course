const filesServices = require("./filesServices");

const uuid = require("uuid");

let users = require("../models/users");
console.log(users);

const usersServices = {
    getAllUsers(){
        return  filesServices.readFile();;

    },
    getUserByID(id){
        const found = users.some(user => user.id === id);

        if (found){            
            return users.filter(user=>user.id === id);
        }
        
    },

     addUser(body){
        const newUser = {
            name: body.name,
            gmail:body.gmail,
            id : uuid.v4()  
        }
       

        if( !newUser.name || !newUser.gmail){
             throw Error("Mail or gmail not included.")
        }
        

        users.push(newUser);
        filesServices.writeFile( users);
        return users;
        
    },

    updateUser(id, body){

        const found = users.some(user => user.id === id);

        if (found){
            const updUser = body;      

            users.forEach(user => {
                if(user.id === id){
                   user.name = updUser.name ? updUser.name : user.name;
                   user.gmail = updUser.gmail ? updUser.gmail : user.gmail;            
                   
                }
            });
            filesServices.writeFile(users);
         
           return users;
           
    
        }else{
          return null; 
        }

  

    },

    deleteUser(id){
        const found = users.some(user => user.id === id);

        if (found){
            users = users.filter(user=>user.id !== id );
            filesServices.writeFile( users);

            return users;
            
        }else{
            return null;
              
        }

    }
}


module.exports = usersServices;