const mongoose = require('mongoose')
const redis = require('redis');
const RepoModel = require("../models/repositories/repositories-model")


const client = redis.createClient();


module.exports = async function cacheData() {
    const count = await RepoModel.count();
    console.log(`Count is ${count}`)
    client.set("count", count, ()=> {console.log("Count set")});
     
  }
  