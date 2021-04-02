const express = require("express");
const repoRoutes = express.Router();

const repoCtrl = require("../controllers/repo-controller");

repoRoutes.get("/api/repos", repoCtrl.getCount);

module.exports = repoRoutes;
