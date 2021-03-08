require('dotenv').config()

const express = require("express");
const app = express();
const mongoose = require('mongoose')

//Import Routes
const postsRouter = require('./routes/posts');
const authRouter = require("./routes/auth");
const dashboardRoutes = require("./routes/dashboard");
const verifyToken = require("./routes/validate-token")




//Middlewares       
app.use(express.json())


//Route middlewares
app.use("/posts", postsRouter); 
app.use("/api/user", authRouter)

//protected with token
app.use("/api/dashboard", verifyToken, dashboardRoutes)


//Connection to DB

mongoose.connect(process.env.DB_CONNECTION,
{ useNewUrlParser: true,useUnifiedTopology: true  }, ()=>{
    console.log("DB connected!");
});



app.listen(process.env.PORT,()=> console.log(`Server started on port ${process.env.PORT}`));