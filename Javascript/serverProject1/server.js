const http = require('http');
const { createSecureServer } = require('http2');

const users = [
  {
    name: "Gohar",
    surname: "Aghajanyan",
    id : 0
  },
  {
    name: "Poxos",
    surname: "Poghosyan",
    id : 1
  },
  {
    name: "Aram",
    surname: "Margaryan",
    id : 2
  }
];

const port = 3000;

function getUserByName(n,request, response) {
  let user = users.find(user => user["name"] === n);
  response.end(JSON.stringify(user));
}

function getUserById(id,request, response) {
  let user = users.find(user => user["id"] == id);
  response.end(JSON.stringify(user));
}


function deleteUserById(id,request, response) {
  let index = users.findIndex(user => user["id"] == id);
  users.slice(index,1)
  response.statusCode(200);
  response.end();
}

function createUser(obj, request, response){
  users.push(obj);
  response.statusCode(201);
  response.end();
}

function updateUser(obj, request, response){
  let user = users.find(user => user["id"] == obj["id"]);
  if("name" in obj){
    user["name"] = obj["name"];
  }
  else if("surname" in obj){
    user["surname"] = obj["surname"];
  }
  response.statusCode(200);
  response.end();
}


http
  .createServer((request, response) => {

    request.on('error', (err) => {
      console.error(err);
   });
   response.on('error', (err) => {
     console.error(err);
  });

    if (request.method === 'GET' ) {
      if(request.url === '/users'){
        response.end(JSON.stringify(users)); 
      }
      else if(request.url.includes( '/users?')){
        let tempMap = request.url.split("?");
        tempMap= tempMap[1].split("=");

        if (tempMap[0] ==="name"){
          getUserByName(tempMap[1], request, response);
        }

        if (tempMap[0] ==="id"){
          getUserById(tempMap[1], request, response);
        }
      }
      else{
        response.statusCode(400);
        response.end();
      }

      
    }
    else if( request.method === 'DELETE'){
      if(request.url.includes( '/users/')){
        let index = request.url.lastIndexOf("/");
        let id = request.url.substring(index+1);       
       
        deleteUserById(id, request, response);
        
      }

    }

    else if (request.method === 'POST' && request.url === '/users') {
      let body = '';
      request.on('data', (chunk) => {
        body+=chunk;
      }).on('end', () => {
        body = JSON.parse(body);
        
       createUser(body, request, response);
      
      });
    } 

    else if (request.method === 'PUT' && request.url === '/users') {
      let body = '';
      request.on('data', (chunk) => {
        body+=chunk;
      }).on('end', () => {
        bodyobj = JSON.parse(body);
        
       updateUser(bodyobj, request, response);
      
      });
    }

  }).listen(port);

console.log(`Server is running on http://localhost:${port}`);



