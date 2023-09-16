package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math Operations in SimpleMath class")
class SimpleMathTest {

	//BDD style - AAA
	
	@Test
	@DisplayName("Test 6.2 + 2 = 8")
	void testSum_SixDotTwoPlusTwo_ShouldReturnEight() {

		//Given / Arrange
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double expected = 8.2D;
		
		//When / Act
		Double result = math.sum(firstNumber, secondNumber);
		
		//Then / Assert
		assertEquals(expected, result, () -> firstNumber + " + " + secondNumber + "did not produce 8.2");
		assertNotEquals(9.2, result);
		assertNotNull(result);
	}

	@Test
	@DisplayName("Test 6.2 - 2 = 4.2")
	void testSubtraction() {
		
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double result = math.subtraction(firstNumber, secondNumber);
		Double expected = 4.2D;
		
		assertEquals(expected, result, () -> firstNumber + " - " + secondNumber + "did not produce 4.2");
		assertNotEquals(9.2, result);
		assertNotNull(result);
	}

	@Test
	@DisplayName("Test 6.2 * 2 = 12.4")
	void testMultiplication() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double result = math.multiplication(firstNumber, secondNumber);
		Double expected = 12.4D;
		
		assertEquals(expected, result, () -> firstNumber + " times(*) " + secondNumber + "did not produce 12.4");
		assertNotEquals(9.2, result);
		assertNotNull(result);
	}
	
	@Test
	@DisplayName("Test 6.2 / 2 = 3.1")
	void testDivision() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double result = math.division(firstNumber, secondNumber);
		Double expected = 3.1D;
		
		assertEquals(expected, result, () -> firstNumber + " divide(/) " + secondNumber + "did not produce 8.2");
		assertNotEquals(9.2, result);
		assertNotEquals(0, secondNumber);
		assertNotNull(result);
		assertNotNull(secondNumber);
	}
	
	@Test
	@DisplayName("Test (6.2 + 2)/2 = 4.1")
	void testMean() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double result = math.mean(firstNumber, secondNumber);
		Double expected = 4.1D;
		
		assertEquals(expected, result, () -> "("+firstNumber + " + " + secondNumber + ")/2"+"did not produce 4.1");
		assertNotEquals(9.2, result);
		assertNotNull(result);
	}
	
	@Test
	@DisplayName("Test sqrt(16) = 4")
	void testSquareRoot() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 16D;
		Double result = math.squareRoot(firstNumber);
		Double expected = 4D;
		
		assertEquals(expected, result, () -> firstNumber+"did not produce 8.2");
		assertNotEquals(10, result);
		assertNotNull(result);
		assertTrue(firstNumber >0 , "Number must be major than zero!");
	}
}
