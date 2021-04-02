const axios = require("axios");
module.exports = async function requestRepos(num, word) {
  let count = num || 5;
  let searchWord = word || "something";
  const data = await axios.get(
    `https://api.github.com/search/repositories?q=${searchWord}&per_page=${count}&offset=1`,
    {
      headers: {
        "Content-Type": "application/json",
      },
    }
  );

  return data.data.items;
};
