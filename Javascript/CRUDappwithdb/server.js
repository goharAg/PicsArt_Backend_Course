require('dotenv').config()

const express = require("express");
const app = express();
const mongoose = require('mongoose')

//Import Routes
const postsRouter = require('./routes/posts');
const authRouter = require("./routes/auth");
const dashboardRoutes = require("./routes/news");
const usersRouter = require("./routes/users")
const verifyToken = require("./middlewares/validate-token")




//Middlewares       
app.use(express.json())


//Route middlewares
 
app.use("/api/auth", authRouter)
app.use("/api/blog/news",  dashboardRoutes);

//protected with token
app.use("/posts", verifyToken, postsRouter);
app.use("/users", verifyToken, usersRouter);



//Connection to DB

mongoose.connect(process.env.DB_CONNECTION,
{ useNewUrlParser: true,useUnifiedTopology: true  }, ()=>{
    console.log("DB connected!");
});



app.listen(process.env.PORT,()=> console.log(`Server started on port ${process.env.PORT}`));