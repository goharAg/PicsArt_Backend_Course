require('dotenv');


const express = require('express');
const mongoose = require('mongoose');
const redis = require('redis');

const configs = require('./configs');
const router = require('./routes/router');
const RepoModel = require("./models/repositories/repositories-model");
const cacheData = require("./utils/cache-data");


const subscriber = redis.createClient();

const app = express()

//built in middleware
app.use(express.json())

// custom routes
app.use(router);


//Redis client listens to changes in db collection
subscriber.on('message', async function (channel, message) {

  console.log(`${message} recieved`);
  await cacheData()

 });

//Redis client subscribed to countChanged channel
 subscriber.subscribe('countChanged');

 

configs.connectDB 
  .then(() => {
    console.log('MongoDB is connected');

    app.listen(configs.env.PORT,async () => {      
      console.log(`Server is running ${configs.env.PORT}`);

      // caches count when connected to server
      await cacheData()     

    });
  })
  .catch(err => console.log(err));

  
