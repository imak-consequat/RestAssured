package api.day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class HTTPRequests_Day1 {
	int id; // for capturing and storing the user id to use it later in create and update  user
	
	//*************Get Users script start's here *********
	//@Test
	void getUsers() {
		System.out.println(" >>>> Get Users Request : GET Method");
		given()
		
		.when().get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log()
		.all();
		
	}
	
	//*************Get Users script end's here *********
	
	//*************Create User script start's here *****
	
	@Test
	void createUser() {
		System.out.println(" >>>> Create User Request: POST Method");
		//using hash map concept of collections to hard-code the data 
		
		HashMap<String,String> data=new HashMap<>();
		
		data.put("name","Ashok");
		data.put("job","IT-Analyst");
		
		given()
			.contentType("application/json")
				.body(data)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
				.log().all();
	}
	
	//*************POST method: Create User script end's here *****
	
	/*
	 * suppose if you need to capture the id declare a variable as int id and then
	 * after send request put semi-colan and then try to capture the response
	 * 
	 */
	
	//*************PUT method: update User script Start's here *****
	
	@Test(priority=1)
	void createUserId() {
		
		System.out.println(" >>>> Create User & Capture User ID Request : POST Method");
		
		//using hash map concept of collections to hard-code the data 
		
		HashMap<String,String> data1=new HashMap<>();
		
		data1.put("name","Ashok");
		data1.put("job","IT-Analyst");
		
		id=given()
			.contentType("application/json")
				.body(data1)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		System.out.println("User id is: "+id);
	}
	
	//************* PUT method update user based on create user starts here*************
	@Test(priority=2,dependsOnMethods= {"createUserId"})
	void updateUserId() {
		
		System.out.println(" >>>> Update User based on Captured User ID Request : PUT Method");
		//using hash map concept of collections to hard-code the data 
		
		HashMap<String,String> data2=new HashMap<>();
		
		data2.put("name","Ashok");
		data2.put("job","TestEngineer");
		
		given()
			.contentType("application/json")
				.body(data2)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
				.log().all();
	}
	//************* PUT method: update userId based on create user End's here*************
	
	//************* DELETE method: Delete userId based on update user Start's here*************
	
	
	
	@Test(priority=3,dependsOnMethods= {"updateUserId"})
	void deleteUserId() {
		
		System.out.println(" >>>> Delete User based on Captured User ID Request : DELETE Method");
		
		given()
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
				.log().all();
	}
	
	//************* DELETE method: Delete userId based on update user End's here*************
}
