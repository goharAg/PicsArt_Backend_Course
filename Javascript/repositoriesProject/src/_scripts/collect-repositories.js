   // reqest https://api.github.com/search/repositories?q=something

require('dotenv');
const axios = require('axios');
const RepoModel = require('../models/repositories/repositories-model');
const connectDB = require('../configs/connectDB')

const redis = require("redis");
const publisher = redis.createClient();
 
publisher.on("error", function(error) {
  console.error(error);
});
 


async function requestRepos() {
  const data = await axios.get(`https://api.github.com/search/repositories?q=something`,  {
    headers: {
      'Content-Type': 'application/json'
    }});
 
  
  return data.data.items.slice(0,5);
}

function processRepos(repos) {
  console.log(typeof repos)
  const mappedRepos = repos.map(repo => ({
    name: repo.name,
    repo_url: repo.url,
  })) 
  return mappedRepos;
}

async function saveRepos(mappedRepos) {
  mappedRepos.forEach( async(element) => {
    let newRepo = new RepoModel(element);
    
    await newRepo.save();

  });

  publisher.publish('countChanged', 'Repos saved in db', function(){
    console.log("published")
   });

}




(async () => {
  
  await connectDB;

  const repos = await requestRepos();

  const mappedRepos = processRepos(repos);

  await saveRepos(mappedRepos)

  
})()






