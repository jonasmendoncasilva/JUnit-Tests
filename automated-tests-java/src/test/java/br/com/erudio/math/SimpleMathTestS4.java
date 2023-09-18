package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Test Math Operations in SimpleMath class")
class SimpleMathTestS4 {
	
	SimpleMath math;
	
	@BeforeAll
	static void setup() {
		System.out.println("Running @BeforeAll method!");
	}
	
	
	@BeforeEach
	void beforeEachMethod() {
		math = new SimpleMath();
	}
	
	//BDD style - AAA
	
	@DisplayName("Test 6.2 / 2 = 3.1")
	@ParameterizedTest
	//@MethodSource("testDivisionInputParameters")
	@MethodSource()
	void testDivision(double firstNumber, double secondNumber, double expected) {
	
		System.out.println("Test "+firstNumber+" / "+secondNumber + " = " + expected);
		Double result = math.division(firstNumber, secondNumber);
	
		assertEquals(expected, result, 2D, 
				() -> firstNumber + " divide(/) " + secondNumber + "did not produce 8.2");
		assertNotEquals(9.2, result);
		assertNotNull(result);
	}
	
	public static Stream<Arguments>  testDivision(){
		return Stream.of(
				Arguments.of(6.2D,2D,3.1D),
				Arguments.of(71D, 14D, 5.07D),
				Arguments.of(18.3D, 3.1D, 5.90D)
				);
	}
	
	
}
