require("dotenv").config();
const configs = require("../src/configs");
const requestRepos = require("./loadRepos");
const processRepos = require("./processRepos");
const saveRepos = require("./saveRepos");
const redisClient = require("./redis");

(async () => {
  try {
    await configs.connectDB;

    const repos = await requestRepos();

    const mappedRepos = processRepos(repos);

    await saveRepos(mappedRepos);

    redisClient.notifyAPI();
  } catch (err) {
    console.log(err);
  }
})();
