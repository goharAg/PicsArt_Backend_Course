const redis = require("redis");

const publisher = redis.createClient();

publisher.on("error", function (error) {
  console.error(error);
});

module.exports.notifyAPI = function () {
  publisher.publish("countChanged", "Repos saved in db", function () {
    console.log("published");
  });
};
