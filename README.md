# RestAssured - Day : 01 learning
-> Pom.xlm file holds all the dependencies required for RestAussured API Automation
-> Day1-HTTP-Request zip file contains the same 
  - GET all Users,
  - POST create single user,
  - POST and capture single user id,
  - PUT update the existying user details using the capture user id in the previous request
  - DELETE a user based on the User Id captured in previous request
-> This by default written in BDD framework (using given(), when(), then()) which also required static imports from restassured docspage.
-> TestNG integration done using the @Test annotation and its parameters like (prioroty & DependsOnMethods)
-> API chaining also done in automation.
-> Data has been hardcoded using HashMap concept of collections class in Java - which accepts adding data in (Key,Value) format using a method called put and the syntax for HashMap --- HashMap<String,String> data=new HashMap<>()
-> Sample request & response has been taken from the Https://reqres.in - web
 
