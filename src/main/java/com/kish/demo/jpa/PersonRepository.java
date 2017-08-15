package com.kish.demo.jpa;

import com.kish.demo.jpa.model.Person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    @Override
    List<Person> findAll();

    @Override
    Person findOne(Long aLong);

    List<Person> findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);
}
