package br.com.erudio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListBDDTest {

	@Test
	void testMockingList_When_SizeisCalled_ShouldReturn10() {
		
		//Given / Arrange
		List<?> list = mock(List.class);
		given(list.size()).willReturn(10);
		
		// When / Act & Then / Assert
		assertThat(list.size(), is(10));
	}
	
	@Test
	void testMockingList_When_SizeisCalled_ShouldReturnMultipleValues() {
		
		//Given / Arrange
		List<?> list = mock(List.class);
		given(list.size()).willReturn(10).willReturn(20);
		
		// When / Act & Then / Assert
		assertThat(list.size(), is(10));
		assertEquals(list.size(), is(20));
		assertEquals(list.size(), is(20));
	}
	@Test
	void testMockingList_When_SizeisCalled_ShouldReturnErudio() {
		
		//Given / Arrange
		var list = mock(List.class);
		given(list.get(0)).willReturn("erudio");
		
		// When / Act & Then / Assert
		assertEquals("erudio", list.get(0));
	}
	@Test
	void testMockingList_When_ThrowsAnException() {
		
		//Given / Arrange
		var list = mock(List.class);
		given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar"));
		
		// When / Act & Then / Assert
		assertThrows(RuntimeException.class, 
			() -> {
			list.get(anyInt());
			}, 
			() -> "Should have an RunTimeException");
	}
}
