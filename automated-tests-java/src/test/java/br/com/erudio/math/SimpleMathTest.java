package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SimpleMathTest {

	@Test
	void testSum() {
		SimpleMath math = new SimpleMath();
		Double result = math.sum(6.2D, 2D);
		Double expected = 8.2D;
		
		assertEquals(expected, result, "6.2 + 2 did not produce 8.2");
		assertNotEquals(9.2, result);
		assertNotNull(result);
	}

}
