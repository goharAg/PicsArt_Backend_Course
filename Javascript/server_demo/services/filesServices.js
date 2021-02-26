require("dotenv").config();
const fs = require("fs")


const path = process.env.USERFILEPATH;

const filesServices = {
readFile(){
    
    try{
        let data = fs.readFileSync(path, "utf-8")
        
        let jsonObj = JSON.parse(data.toString()); 
        console.log(jsonObj);
        return jsonObj; 
    }
    catch(error){
        console.log(error)
        console.log("Error while reading file")
    }

},


 writeFile( data){
    let updData = JSON.stringify(data);

    try {
        fs.writeFileSync(path, updData);
        console.log("JSON obj written");
    } catch (error) {
        console.error(err);
    }

}
}

module.exports = filesServices;











