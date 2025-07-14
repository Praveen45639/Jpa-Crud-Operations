package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepo;
	
	public Person savePerson(Person person) {
		return personRepo.save(person);	
	}
	
	public Optional<Person> getById(int id) {
		return personRepo.findById(id);
	}
	
	public List<Person> getAllPersons() {
		return personRepo.findAll();
	}
	
	public String deleteById(int id) {
	    Optional<Person> person = personRepo.findById(id);
	    if (person.isPresent()) {
	        personRepo.deleteById(id);
	        return "Person deleted successfully";
	    } else {
	        return "Person not found";
	    }
	}
	
	public Person savePerson1(Person person) {
		return personRepo.save(person);
	}

}
