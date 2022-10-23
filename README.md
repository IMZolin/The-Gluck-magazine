## Online culture magazine "The Gluck" -  Backend
### It's :
1. An online culture magazine  for free publication to novice journalists.
2. An external order from students journalists
3. A university project for the Java and API subjects in the SPbPU(Peter the Great St. Petersburg Polytechnic University)
### Frontend part 
* https://github.com/IMZolin/The-Gluck-magazine-front
### The manual for deploying and configuring the application locally

1. Clone this repo by using
    ```
     git clone http://github.com/
    ```
2. The application will be delivered as a jar archive.
3. It is necessary that the JRE (Java Runtime Environment) was installed on the working machine.
4. To run the application type in the command line: "java -Duser.timezone=GMT -jar <name of the file with the extension .jar>"
5. sAll done, you've launched the application!

### The logic of the application
#### 1. Tools 
* Spring framework(Java language)
* Database - PostgreSQL database 
  * Create database
    ```Sql
        CREATE DATABASE thegluckdb
            WITH
            OWNER = postgres
            ENCODING = 'UTF8'
            LC_COLLATE = 'Russian_Russia.1251'
            LC_CTYPE = 'Russian_Russia.1251'
            TABLESPACE = pg_default
            CONNECTION LIMIT = -1
            IS_TEMPLATE = False;
    
        COMMENT ON DATABASE thegluckdb
        IS 'This is the database for online magazine "The Gluck"';
    
    ```
  * Tables:
    1. users 
       * Long id
       * String username
       * String first_name
       * String last_name
       * String email
       * String password
    2. user_role
        * Long user_id (link to users)
        * Set String roles
    3. articles
       * Long id
       * String title
       * String description
       * String text
       * LocalDateTime creation_date
       * Long user_id (link to users)
       * Int likes (links to article_likes, users)
       * Long comments (link to comments, users) 
    4. comments
       * Long id
       * String text
       * Long article_id
       * Long user_id
       
#### 2.  Application Structure
* Objects consist of entity, model, repos, service, controller
  * Entity
    * The layer to work with database entities using JPA
  * Model
    * The layer is used for the response from the server to the client part
  * Repos(repository)
    *  The layer which implements internal work of Spring framework to get data from database
  * Service 
    * The service package is necessary to implements internal logic of the application and the relationship between user's requests and database
  * Controller
    * The layer for all possible CRUD request
* Сonfig is used to correctly respond to template requests, for example, registration (user authorization)
* Exceptions consider certain cases where there may be an error (for example, when the user is not found in the database)
#### 3. Requests(using controllers, services, exceptions):
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
   - https://www.postman.com/lunar-module-explorer-97798172/workspace/the-gluck