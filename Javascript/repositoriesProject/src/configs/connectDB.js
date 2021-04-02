
const mongoose = require('mongoose')
const db = require('./db');



module.exports = mongoose.connect(db.url, db.options);
