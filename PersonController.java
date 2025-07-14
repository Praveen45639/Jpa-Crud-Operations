package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/save")
	public Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Person> getById(@PathVariable int id) {
		return personService.getById(id);	
	}
	
	@GetMapping("/getAll")
	public List<Person> getAllPersons(){
		return personService.getAllPersons();	
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
	    String response = personService.deleteById(id);
	    if (response.equals("Person deleted successfully")) {
	        return ResponseEntity.ok(response);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person){
	Optional<Person> existingPerson = personService.getById(id);
	 if (existingPerson.isPresent()) {
	        Person person1 = existingPerson.get();
	        person1.setName(person.getName());
	        person1.setEmail(person.getEmail());
	        person1.setPassword(person.getPassword());
	        
	        personService.savePerson1(person1);
	        return ResponseEntity.ok(person1);
	 }
	 else {
		 return ResponseEntity.notFound().build();
	 }

	}
}
