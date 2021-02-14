class User{
    constructor(name, surname  ){
        this.name = name
        this.surname = surname
        this.items = []
        

    }

    addItem(type, title, price ){
        this.items.push(new Item(type, price, title))
    }
}