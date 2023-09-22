package br.com.erudio.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SpyTest {

	@Test
	void testV1() {
		// Given / Arrange
		List<String> mockArrayList = spy(ArrayList.class);

		// when && then
		assertEquals(0, mockArrayList.size());

		when(mockArrayList.size()).thenReturn(5);
		mockArrayList.add("Foo-Bar");

		assertEquals(5, mockArrayList.size());
	}

	@Test
	void testV2() {
		// Given / Arrange
		List<String> spyArrayList = spy(ArrayList.class);

		// when && then
		assertEquals(0, spyArrayList.size());


		spyArrayList.add("Foo-Bar");
		assertEquals(1, spyArrayList.size());
	

		spyArrayList.remove("Foo-Bar");
		assertEquals(0, spyArrayList.size());
	}
}
