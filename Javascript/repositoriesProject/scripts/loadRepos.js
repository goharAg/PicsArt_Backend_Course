const axios = require('axios');
module.exports = async function requestRepos(num) {
    let count = num || 5;
    const data = await axios.get(`https://api.github.com/search/repositories?q=something&per_page=${count}&offset=1`, {
      headers: {
        'Content-Type': 'application/json'
      }
    });
  
  
    return data.data.items;
  }

  
  