const mongoose = require('mongoose');
const RepoSchema = mongoose.Schema({
    id:{
        type:Number,
        required:true
    },
    name:{
        type:String,
        requred:true,
    },
    repo_url:{
        type:String,
        required:true
    },
    owner_name:{
        type:String,
        required:true,
    },
    owner_id:{
        type:Number,
        required:true
    },


});




module.exports = mongoose.model('Repository', RepoSchema);