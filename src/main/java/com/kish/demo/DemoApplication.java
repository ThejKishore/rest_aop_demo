package com.kish.demo;

import com.kish.demo.jpa.PersonService;
import com.kish.demo.jpa.model.Person.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kish.demo"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonService personService){
		return args -> {
			Person person = new Person("Thej Kishore","Karuneegar");
			personService.savePerson(person);
		};
	}
}
