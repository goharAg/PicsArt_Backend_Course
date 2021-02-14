let adsMixin  = {
    reccomend(){
        console.log(`This is very good ${this.title}`)
    },

    discount (percent ){
        consloe.log(`${this.title} is discounted by ${percent} %. Now the price is ${this.price - this.price * percent / 100}`);

    }

    

};


module.exports = adsMixin;