package com.kish.demo.controller;


import com.kish.demo.jpa.PersonService;
import com.kish.demo.jpa.model.Person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person" )
public class PersonController extends AbstractRestHandler{

    @Autowired
    PersonService personService;


    @RequestMapping(value = "",method = RequestMethod.GET ,produces = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Person getPerson(@PathVariable("id") Long personId){
        throw new RuntimeException("path not found exceptions");
//        return personService.getPerson(personId);
    }

}
