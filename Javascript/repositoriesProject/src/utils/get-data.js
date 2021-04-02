const redis = require("redis");
const client = redis.createClient();
module.exports = function(req,res,next){
    try{
        client.get("count", (err, count)=>{
            if(err) throw err;

            if(count){
                
                res.status(200).json({count, msg:"data from redis cache"})
            }
            else{
                res.status(404).json({msg:"There are no repos"})
            }
        })
    }
    catch(err){
        console.log(err)
        res.status(500).json({msg:err})
    }
}