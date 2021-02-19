function config(){

    const fs = require('fs');

    const path = require("path");
    const absolutePath = path.resolve("Javascript/app/.env");
    try{
        const data = fs.readFileSync(absolutePath, "utf8");
        
        let lines = data.split("\n")
        
        let parts;
        for (l of lines){
            
            if (l[0] == "#")
            {             
                continue
            }
            if(l.charAt(0) ==  l.charAt(0).toUpperCase() && l.includes("=") && l.charAt(0) != "=" )
            {
              
                let varName = l.substring(0, l.indexOf("="))
                let value = l.substring(l.indexOf("=")+1 )

               
                process.env[varName] = value;
               
            }
        }
        
    }
    catch(err){
        console.log(`Error ${err}`);
    }
}
config()

module.exports = {
    config
}



