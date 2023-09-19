package br.com.erudio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.erudio.model.Person;
import br.com.erudio.model.service.IPersonService;
import br.com.erudio.model.service.PersonService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonServiceTest {

	Person person;
	Person actual;
	IPersonService service;
	
	@BeforeEach
	@Order(1)
	void setupPerson() {
		person = new Person(
				"Keith",
				"Moon",
				"kmoon@erudio.com.br",
				"Wembley - UK",
				"Male");
	}
	
	@BeforeEach
	@Order(2)
	void setupPersonServiceReturned() {
		//Given / Arrange
		service = new PersonService();
		
		//When  / Act
		actual = service.createPerson(person);
	}

	@DisplayName("When Create a Person With Success Should Contains a String in Returned a Person Object")
	@Test
	void testCreatePerson_WhenSucess_ShouldContainsStringsInReturnPersonObject() {
		
		//Then  / Arrest
		assertNotNull(actual.getId(), () -> "Person ID is missing!");
		
		assertNotNull(actual, () -> "Created Person Should not have return null");
		assertEquals(person.getFirstName(), actual.getFirstName(), ()-> "The FirstName is different!");
		assertEquals(person.getLastName(), actual.getLastName(), ()-> "The LastName is different!");
		assertEquals(person.getEmail(), actual.getEmail(), ()-> "The Email is different!");
		assertEquals(person.getAddress(), actual.getAddress(), ()-> "The Address is different!");
		assertEquals(person.getGender(), actual.getGender(), ()-> "The FirstName is different!");
	}
	
	@DisplayName("When Create a Person With Success Should Contains a Male or Female in Gender in Returned a Person Object")
	@ParameterizedTest
	@ValueSource(strings = {"Male","Female"})
	void testCreatePerson_WhenSucess_ShouldContainsMaleOrFemaleInReturnPersonObject(String gender) {
		//Then  / Arrest
		assertEquals(person.getGender(), gender, () -> "The Gender is different");
	}

	@DisplayName("When Create a Person With Null Email Should Throw an Exception")
	@Test
	void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {
		
		person.setEmail(null);
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
				()-> service.createPerson(person), 
				()-> "Empty e-Mail should have cause an IllegalArgumentException!");
	
		assertEquals("Person Email is empty", exception.getMessage(), ()-> "Message is not the same!");
	}
}
