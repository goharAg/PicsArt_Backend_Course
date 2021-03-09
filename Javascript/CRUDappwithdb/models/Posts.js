const mongoose = require('mongoose');
const PostSchema = mongoose.Schema({
    title:{
        type:String,
        required: true
    },
    description:{
        type:String,
        required: false
    },
    photo:{
        type:Buffer,
        required:false,
    },
    author:{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User',  
        required:true
    },

    date:{
        type:Date,
        default:Date.now,
    }
});

module.exports = mongoose.model('Post', PostSchema);