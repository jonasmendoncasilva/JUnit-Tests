package br.com.erudio;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(4)
class FooBarTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		System.out.println("Hello JUnit");
	}

}
