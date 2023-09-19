package br.com.erudio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.erudio.model.Person;
import br.com.erudio.model.service.IPersonService;
import br.com.erudio.model.service.PersonService;

public class PersonServiceTest {

	Person person;
	
	@BeforeEach
	void setup() {
		person = new Person(
				"Keith",
				"Moon",
				"kmoon@erudio.com.br",
				"Wembley - UK",
				"Male");
	}
	
	@DisplayName("When Create a Person With Success Should Return a Person Object")
	@Test
	void testCreatePerson_WhenSucess_ShouldReturnPersonObject() {
		//Given / Arrange
		IPersonService service = new PersonService();
		
		//When  / Act
		Person actual = service.createPerson(person);
		
		//Then  / Arrest
		assertNotNull(actual, () -> "Created Person Should not have return null");
	}
	@DisplayName("When Create a Person With Success Should Contains FirstName in Returned a Person Object")
	@Test
	void testCreatePerson_WhenSucess_ShouldContainsFirstNameInReturnPersonObject() {
		//Given / Arrange
		IPersonService service = new PersonService();
		
		//When  / Act
		Person actual = service.createPerson(person);
		
		//Then  / Arrest
		assertEquals(person.getFirstName(), actual.getFirstName(), ()-> "The FirstName is different!");
	}
}
