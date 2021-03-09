In the .env file fill in PORT, DB_CONNECTION and TOKEN_SECRET

Photos should only be .jpg files

REQUEST EXAMPLES

Without registration you can send GET request to 

http://localhost:3001//api/blog/news/



And also you can register and login

Register:
http://localhost:3001//api/auth/register

Body is a JSON obj consisiting of fields:

    name:
    gmail:
    password:

Login:

http://localhost:3001//api/auth/login

For login provide a JSON obj with fields:

    gmail:
    password:


After Authentication you can access

GET your all posts
http://localhost:3001//posts/

GET most recent post of all users
http://localhost:3001//posts/recent


GET a post by ID
http://localhost:3001//posts/i9289242398h9832

GET a photo of a post by ID
http://localhost:3001//posts/i9289242398h9832/photo


POST a post (create)
http://localhost:3001//posts/

TO create post you should provide following fields:
    title: required
    description: optional
    photo : optional 



POST a photo of a post by ID (add a photo to already existing post)
http://localhost:3001//posts/i9289242398h9832/photo


If the photo exists it replaces with new photo, if doesn't exist it adds to post

PUT a post by ID (Edit post, not photo field)
http://localhost:3001//posts/i9289242398h9832

DELETE a photo of a post by ID
http://localhost:3001//posts/i9289242398h9832/photo



DELETE  a post by ID
http://localhost:3001//posts/i9289242398h9832


GET your info
http://localhost:3001//users/info

GET user by ID
http://localhost:3001//users/182472c98cm921xs

GET user's posts by user's ID
http://localhost:3001//users/182472c98cm921xs/posts


PUT your info(edit your info)
http://localhost:3001//users/edit






