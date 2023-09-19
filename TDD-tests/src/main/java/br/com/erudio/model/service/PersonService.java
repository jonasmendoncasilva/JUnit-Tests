package br.com.erudio.model.service;

import br.com.erudio.model.Person;

public class PersonService implements IPersonService {

	@Override
	public Person createPerson(Person person) {
		
		return new Person();
	}

}
