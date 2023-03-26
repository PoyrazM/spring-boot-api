package com.restapi.springbootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
//@RestController
public class SpringBootApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiApplication.class, args);
	}

//	@GetMapping("/greet")
//	public GreetResponse greet() {
//		return new GreetResponse(
//				"Hello World !",
//				List.of("Java", "Javascript", "Swift"),
//				new Person("Mertcan", 23, true, 30_000)
//				);
//	}
//
//	record Person(String name, int age, boolean isAdult, double savings) {}
//
//	record GreetResponse(
//			String greet,
//			List<String> favProgrammingLanguage,
//			Person person) {}
}
