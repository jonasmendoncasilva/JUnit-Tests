package br.com.erudio.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class OrderServiceTest {

	OrderService service = new OrderService();
	private final UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
	private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2023, 7, 4, 5, 10);

	@Test
	@DisplayName(value = "Should Include Random OrderId When No OrderId Exists")
	void testShouldIncludeRandomOrderId_When_NoOrderIdExists() {
		// Given
		try (MockedStatic<UUID> mockedUuId = mockStatic(UUID.class)) {

			mockedUuId.when(UUID::randomUUID).thenReturn(defaultUuid);

			// When
			Order result = service.createOrder("MacBook", 2L, null);

			// Then
			assertEquals(defaultUuid.toString(), result.getId());
		}
	}

	@Test
	@DisplayName(value = "Should Include Current Time When Create a New Order")
	void testShouldIncludeCurrentTime_When_CreateANewOrder() {
		// Given
		try (MockedStatic<LocalDateTime> mockedUuId = mockStatic(LocalDateTime.class)) {

			mockedUuId.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

			// When
			Order result = service.createOrder("MacBook", 2L, null);

			// Then
			assertEquals(defaultLocalDateTime, result.getCreationDate());
		}
	}
}
