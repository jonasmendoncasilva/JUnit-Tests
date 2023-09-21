package br.com.erudio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {

	@Test
	void testMockingList_When_SizeisCalled_ShouldReturn10() {
		
		//Given / Arrange
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10);
		
		// When / Act & Then / Assert
		assertEquals(10, list.size());
	}
	
	@Test
	void testMockingList_When_SizeisCalled_ShouldReturnMultipleValues() {
		
		//Given / Arrange
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);
		
		// When / Act & Then / Assert
		assertEquals(10, list.size());
		assertEquals(20, list.size());
		assertEquals(20, list.size());
	}
	@Test
	void testMockingList_When_SizeisCalled_ShouldReturnErudio() {
		
		//Given / Arrange
		var list = mock(List.class);
		when(list.get(0)).thenReturn("erudio");
		
		// When / Act & Then / Assert
		assertEquals("erudio", list.get(0));
	}
}
