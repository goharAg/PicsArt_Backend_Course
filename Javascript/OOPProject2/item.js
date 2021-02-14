import adsMixin from "./ads.js"

class Item {
    constructor(type, price, title){
        this.type = type
        this.price = price
        this.title = title
    }
}

Object.assign(Item.prototype, adsMixin)




