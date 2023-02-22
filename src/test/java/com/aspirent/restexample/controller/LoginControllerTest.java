package com.aspirent.restexample.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.aspirent.restexample.model.Greeting;
import com.aspirent.restexample.model.User;

public class LoginControllerTest {

	@Test
	public void greet() {
		LoginController loginController = new LoginController();

		assertEquals(loginController.greet(), "Hello!");
	}

	@Test
	public void greetUserByPath() {
		LoginController loginController = new LoginController();

		assertEquals(loginController.greetUserByPath("Test"), "Hello Test!");
	}

	@Test
	public void greetUserByRequest() {
		LoginController loginController = new LoginController();

		assertEquals(loginController.greetUserByPath("Test"), "Hello Test!");
	}

	@Test
	public void greetUserByPost() {
		LoginController loginController = new LoginController();
		User user = new User();
		user.setUsername("TestUser");
		user.setPassword("password123");

		Greeting greeting = loginController.greetUserByPost(user);

		assertEquals(greeting.getUser(), user);
		assertEquals(greeting.getGreeting(), "Hello TestUser!");
	}
}
