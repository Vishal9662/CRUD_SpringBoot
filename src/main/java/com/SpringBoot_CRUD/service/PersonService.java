package com.SpringBoot_CRUD.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringBoot_CRUD.Repository.PersonRepository;
import com.SpringBoot_CRUD.model.Person;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
//	SAVE Data
	public Person saveData(Person person)
	{
		return personRepository.save(person);
	}
	
	
//	GET All Data	
	public List<Person> getAllData()
	{
		List<Person> p=personRepository.findAll();
		return p;
	}
	
	
//  GET Data By Id	
	public Optional<Person> getDataById(int id)
	{
		Optional<Person> p=personRepository.findById(id);
		return p;
	}
	
	
//	UPDATE Data	
	public ResponseEntity<String> updateData(int id, Person person)
	{
		Person p1=personRepository.getById(id);
		if(p1!=null)
		{
			p1.setName(person.getName());
			p1.setAge(person.getAge());
			p1.setContact_number(person.getContact_number());
			p1.setEmail(person.getEmail());
			personRepository.save(p1);
			
			return ResponseEntity.status(200).body("Data updated succesfully");
		 
		}
		else
		{
			return ResponseEntity.status(404).body("User ID does not exist...");
		}
		
	}

	
//	DELETE Data	
	public boolean deleteData(int id)
	{
		Optional<Person> p=personRepository.findById(id);
		if(p.isPresent())
		{
			 personRepository.deleteById(id);
			 return true;
		}
		else
		{
			return false;
		}
	}
}
