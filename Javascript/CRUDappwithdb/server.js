require('dotenv').config()

const express = require("express");
const app = express();
const mongoose = require('mongoose')

//Import Routes
const postsRouter = require('./routes/posts')



//Middlewares       
app.use(express.json())



app.use("/posts", postsRouter); 


//Connection to DB

mongoose.connect(process.env.DB_CONNECTION,
{ useNewUrlParser: true,useUnifiedTopology: true  }, ()=>{
    console.log("DB connected!");
});



app.listen(3000,()=> console.log(`Server started on port ${process.env.PORT}`));