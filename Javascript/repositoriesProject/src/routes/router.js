const express = require('express')
const router = express.Router()

const repoRoutes = require('./repo-route');

// public
router.use(repoRoutes);


module.exports = router