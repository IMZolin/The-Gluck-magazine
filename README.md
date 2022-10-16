## Online culture magazine "The Gluck" for free publication to novice journalists.
### It's :
1. An external order from students journalists
2. A university project for the Java and API subjects in the SPbPU(Peter the Great St. Petersburg Polytechnic University)

### Requests(using controllers, services, exceptions):
1. Login
   - Checking the existence of a user by email
   - Checking the match of the entered password and the existing one
2. Signup (request + response)
   - Checking the uniqueness of mail
   - Checking the uniqueness of username
3. Mini-requests with
    - Users
      - getUsers - Get all users
      - getByEmail = Get one user by email
      - getOne - Get a user with the request user/{id}
      - getAll - Get all users
    - Articles
      - getById - Get article by id
      - delete - Delete one article by id
      - getByTitle - Get one article by title
      - getAll - Get all articles
      - editArticle - Edit article using model of article

### Postman resource:
   - https://www.getpostman.com/collections/1169acc842a12cc04081