package com.SpringBoot_CRUD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringBoot_CRUD.model.Person;
import com.SpringBoot_CRUD.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	PersonService personService;
	
	@RequestMapping("/person/save")
	public ResponseEntity<Person> save(@RequestBody Person person)
	{
		Person p=personService.saveData(person);
		return ResponseEntity.status(200).body(p);
	}
	
	@RequestMapping("/person/getAll")
	public ResponseEntity<List<Person>> getAll()
	{
		List<Person> p1=personService.getAllData();
		return ResponseEntity.status(200).body(p1);
	}
	
	@RequestMapping("/person/get/Data/{id}")
	public ResponseEntity<Optional<Person>> getById(@PathVariable("id") int id)
	{
		Optional<Person> p1=personService.getDataById(id);
		return ResponseEntity.status(200).body(p1);
		
	}
	
	@RequestMapping("/person/update/Data")
	public ResponseEntity<String> updateDataById(@RequestHeader int id,@RequestBody Person person)
	{
		return personService.updateData(id,person);
	}
	
	
	@RequestMapping("/person/delete/Data/{id}")
	public ResponseEntity<Optional<Person>> deleteById(@PathVariable("id") int id)
	{
		Optional<Person> p1=personService.getDataById(id);
		if(p1.isPresent())
		{
			personService.deleteData(id);
			return ResponseEntity.status(200).body(p1);
		}
		else
		{
			return ResponseEntity.status(404).body(null);
		}
	}
}
