


module.exports  = function processRepos(repos) {
    
    const mappedRepos = repos.map(repo => ({
      id: repo.id,
      name: repo.name,
      repo_url: repo.url,
      owner_name: repo.owner.login,
      owner_id :repo.owner.id,
      
    }))
    return mappedRepos;
  }


