const fs = require('fs');
const path = require("path");
const absolutePath = path.resolve("Javascript/app/.env");



function config(){   
    try{
        const data = fs.readFileSync(absolutePath, "utf8");        
        let lines = data.split("\n")        
        let parts;

        for (l of lines){            
            if (l[0] == "#")           
                continue                       
              
            parts = l.split("=", 2);
            if ( parts.length != 2)
                continue
               
            process.env[parts[0]] = parts[1];       
        }        
    }
    catch(err){
        console.log(`Error ${err}`);
    }
}


module.exports = {
    config
}



