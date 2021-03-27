const fs = require('fs')
const express = require('express')
const app = express()
const port = 3030

let typeMap = new Map();
typeMap.set("png", "image/png");
typeMap.set("jpeg", "image/jpeg");
typeMap.set("txt", "text/enriched");
typeMap.set("pdf", "application/pdf");
typeMap.set("html", "html");



app.get('/*.*', (req, res, next) => {
 
  const root = "./public"
  let path = root + req.url;

    
  try{
    const buffer = fs.readFileSync(path);

    let type = req.url.substring(req.url.lastIndexOf(".") +1);
    let contentType = typeMap.has(type) ? typeMap.get(type) : "application/content-stream";


    res.setHeader('content-type',contentType );

    res.status(200).send(buffer);

  }catch(err){

    res.status(404).json("Such file doesn't exist");
  }
});

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})
