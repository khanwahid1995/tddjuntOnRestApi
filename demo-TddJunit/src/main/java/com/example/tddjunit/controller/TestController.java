/**
 * @author - wahid -date : 21-Apr-2019 4:43:38 pm
 */
package com.example.tddjunit.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tddjunit.model.UserDTO;

/**
 * @author - wahid -date : 21-Apr-2019 4:43:38 pm
 *
 */

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/sum/{a}/{b}")
	public ResponseEntity<Integer> sum(@PathVariable(name = "a") Integer a , @PathVariable(name="b") Integer b) {
		System.out.println(a+b);
		return new  ResponseEntity<Integer>(a+b, HttpStatus.OK);
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<UserDTO> getUser(){
		UserDTO user= new UserDTO();
		user.setUsername("wahid");
		
		return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
	}
	
	@PostMapping("/postuser")
	public ResponseEntity<UserDTO> postUser(@RequestBody Map<String,String> input){
		
		
		System.out.println(input);
		UserDTO user= new UserDTO();
		user.setUsername(input.get("username"));
		
		return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
	}
	
}
