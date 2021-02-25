require("dotenv").config();
const express  = require('express');
const app = express();
const userRouter = require("./routes/userRoutes.js");
const PORT = process.env.PORT || 3000;


app.use(express.json());
app.use(express.urlencoded({extended : false}));


app.use("/api/users", userRouter);




app.listen(PORT, ()=> console.log(`Server started on port ${PORT}`));