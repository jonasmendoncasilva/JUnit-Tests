package br.com.erudio;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Order(3)
@TestMethodOrder(MethodOrderer.MethodName.class)
class MethodOrderedRandonlyByName {

	@Test
	void testA() {
		System.out.println("Running Test A");
	}
	
	@Test
	void testB() {
		System.out.println("Running Test A");
	}
	@Test
	void testC() {
		System.out.println("Running Test A");
	}
	@Test
	void testD() {
		System.out.println("Running Test A");
	}

}
