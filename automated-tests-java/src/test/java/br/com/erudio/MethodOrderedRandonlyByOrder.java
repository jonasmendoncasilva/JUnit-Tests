package br.com.erudio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

//@Order(2)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MethodOrderedRandonlyByOrder {

	StringBuilder actualValue = new StringBuilder();
	
	@AfterEach
	void afterEach() {
		System.out.println("The actual value is "+ actualValue);
	}
	
	@Test
	@Order(1)
	void testA() {
		System.out.println("Running Test A");
		actualValue.append("1");
	}
	
	@Test
	@Order(3)
	void testB() {
		System.out.println("Running Test A");
		actualValue.append("3");
	}
	
	@Test
	@Order(4)
	void testC() {
		System.out.println("Running Test A");
		actualValue.append("4");
	}
	
	@Test
	@Order(2)
	void testD() {
		System.out.println("Running Test A");
		actualValue.append("2");
	}

}
