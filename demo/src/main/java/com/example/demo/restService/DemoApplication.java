package com.example.demo;

 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;

 import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





 
 @CrossOrigin(origins = "http://localhost:4200")
 @SpringBootApplication
 @RestController
 public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// LOGIN PAGE
	@RequestMapping(value = "/user/credentials", method = RequestMethod.GET)
	public ResponseEntity<String> getCredentials(@RequestParam(value="credentials", defaultValue= "nocreds") String credentials) {
		if (credentials.equals("nocreds")){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		String[] tokens = credentials.split("_");
		String username = tokens[0];
		String password = tokens[1];
		System.out.println("Username: " + username);
		System.out.println("Pass: " + password);
		// query and see if both username and password exists
		// if exist return OK(200) else return NO_CONTENT(204)
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	// SIGNUP PAGE
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User newUser) {
		if (newUser.isValid()){
			// create in DB here
			// check if user exists, if so then return NOT_ACCEPTABLE(406) else return CREATED(201)
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// MAIN PAGE
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User getUser(@RequestParam(value = "id", defaultValue = "100") String id) {
		// query in DB here if user exits, if so return OK(200) else return NO_CONTENT(204)
		return new User(new Integer(id), "classes", "goals", "fun", "other", "interesting", "username", "password");
	}

	public User updateUser(@RequestBody User updatedUser) {
		if (updatedUser.isValid()){
			//check if user exist, if continue with get user query and logic after, else return NO_CONTENT(204)
			// addded logic here to check what was updated and updated the DB accordingly.
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}
