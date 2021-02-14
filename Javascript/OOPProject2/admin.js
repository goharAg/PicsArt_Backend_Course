class Admin extends User{

   
    constructor(name, surname){
        super(name, surname);
        users = []
    }


    viewAllsers(){
        for(u of users){
            console.log(u.name +" " + u.surname);
        }

    }

    

    

    addUser(name, surname){
        users.push(new  User(name, surname));

    }




}