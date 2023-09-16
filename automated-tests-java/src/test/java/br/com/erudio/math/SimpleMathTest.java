package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SimpleMathTest {

	@Test
	void testSum() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double result = math.sum(firstNumber, secondNumber);
		Double expected = 8.2D;
		
		assertEquals(expected, result, () -> firstNumber + " + " + secondNumber + "did not produce 8.2");
		assertNotEquals(9.2, result);
		assertNotNull(result);
	}

}
