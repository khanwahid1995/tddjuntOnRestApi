package com.example.tddjunit;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.tddjunit.model.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("demo Test cases")
public class DemoTddJunitApplicationTests {
	
	@Autowired
	TestRestTemplate rest;

	@Test
	@DisplayName("testing  get method in getuser")
	public void test1() {
		
		ResponseEntity<UserDTO> response =rest.getForEntity("/test/getuser", UserDTO.class);
		System.out.println(response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		UserDTO user= response.getBody();
		assertEquals("wahid", user.getUsername());
	}
	
	@Test
	@DisplayName("testing  post method in post user")
	public void test2() {
		
		Map<String,Object> input= new HashMap<>();
		input.put("username", "wahid2");
		ResponseEntity<UserDTO> response =rest.postForEntity("/test/postuser",input ,UserDTO.class);
		System.out.println(response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		UserDTO user= response.getBody();
		assertEquals(input.get("username"), user.getUsername());
	}

}
