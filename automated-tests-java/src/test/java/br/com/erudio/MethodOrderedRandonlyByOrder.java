package br.com.erudio;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Order(2)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MethodOrderedRandonlyByOrder {

	@Test
	@Order(1)
	void testA() {
		System.out.println("Running Test A");
	}
	
	@Test
	@Order(3)
	void testB() {
		System.out.println("Running Test A");
	}
	@Test
	@Order(4)
	void testC() {
		System.out.println("Running Test A");
	}
	@Test
	@Order(2)
	void testD() {
		System.out.println("Running Test A");
	}

}
