const filesServices = require("../services/filesServices")



let users = filesServices.readFile();

module.exports = users;