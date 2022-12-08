package com.SpringBoot_CRUD.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot_CRUD.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>
{

	Person save(Optional<Person> p1);
	
	


}
