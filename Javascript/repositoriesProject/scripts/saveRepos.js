const RepoModel = require('../src/models/repositories/repositories-model');

module.exports = async function saveRepos(mappedRepos) {

    await RepoModel.create(mappedRepos);
  
  }

