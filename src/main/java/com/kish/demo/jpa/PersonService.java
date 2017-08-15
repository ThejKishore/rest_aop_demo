package com.kish.demo.jpa;

import com.kish.demo.jpa.model.Person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {


    @Autowired
    PersonRepository personRepository;

    public List<Person>  getAllPerson(){
       return personRepository.findAll();
    }


    public Person  getPerson(Long personId){
        return personRepository.findOne(personId);
    }


    public List<Person> getPersonByFirstName(String personFirsName){
        return personRepository.findByFirstName(personFirsName);
    }

    public List<Person> getPersonByLastName(String personLastName){
        return personRepository.findByLastName(personLastName);
    }

    public void savePerson(Person person){
        personRepository.save(person);
    }


}
