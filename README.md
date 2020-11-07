# api_demo
## Requirement
- Mysql
- Java 15 With Intellij
## How to use
### Import Database
- import [sql file](https://github.com/bhieu79/api_demo/blob/main/api-demo/src/main/resources/database/Dump20201107.sql) to mysql
- username: root / password: root (can be edited [here](https://github.com/bhieu79/api_demo/blob/main/api-demo/src/main/resources/application.properties))
### Import project to Intellij
### Run the project
### Use Postman to test 
- Usage:  \
         http://localhost:8080/api/user?search=id:3  \
         http://localhost:8080/api/user?search=id>1,name={insert_name}  \
         http://localhost:8080/api/user?search=all  \
         http://localhost:8080/api/user/1 (search by ID)
         
         

