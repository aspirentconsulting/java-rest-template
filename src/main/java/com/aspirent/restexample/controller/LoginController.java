package com.aspirent.restexample.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.aspirent.restexample.model.Greeting;
import com.aspirent.restexample.model.User;

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("greet")
    public String greet() {
        return "Hello!";
    }

	@GetMapping("greetUserByPathVariable/{name}")
	public String greetUserByPath(@PathVariable("name") String name) {
		return "Hello "+name+"!";
	}

	@GetMapping("greetUserByRequestVariable")
	public String greetUserByRequest(@RequestParam(name="name") String name) {
		return "Hello "+name+"!";
	}

	@PostMapping(
			path = "/greetUserByPost",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Greeting greetUserByPost(@RequestBody User user) {
		Greeting greeting = new Greeting();
		greeting.setGreeting("Hello "+user.getUsername()+"!");
		greeting.setUser(user);

		return greeting;
	}
}
