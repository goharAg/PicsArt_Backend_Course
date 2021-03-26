const mongoose = require('mongoose');
const RepoSchema = mongoose.Schema({
    name:{
        type:String,
        requred:true,
    },
    repo_url:{
        type:String,
        required:true
    },

});




module.exports = mongoose.model('Repository', RepoSchema);