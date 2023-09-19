package br.com.erudio.model.service;

import java.util.concurrent.atomic.AtomicLong;

import br.com.erudio.model.Person;

public class PersonService implements IPersonService {

	@Override
	public Person createPerson(Person person) {
		
		if(person.getEmail() == null || person.getEmail().isBlank()) 
			throw new IllegalArgumentException("Person Email is empty");
		
		var id = new AtomicLong().incrementAndGet();
		person.setId(id);
		return person;
	}

}
