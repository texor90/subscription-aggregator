package com.sa.jacek.sa;

import com.sa.jacek.sa.order.OrderDto;
import com.sa.jacek.sa.order.OrderService;
import com.sa.jacek.sa.user.UserDto;
import com.sa.jacek.sa.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class SaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	OrderService orderService;

	@Test

		// test sprawdza czy w trakcie tworzenia zamówioenia zostanie wygenerowana data zakupu.
		// wywoałenie testu poprzez zakomentwoanie linijki 29 w OrderService

	void testPurchaseDate() {
		// given - tworze order
		OrderDto dto = new OrderDto();
		dto.setProductId(16L);
		dto.setUserId(6L);

		// when - serwis zapisze order
		var result = orderService.addOrder(dto);

		// then - bedzie wygenerowana data zakupu
		Assertions.assertNotNull( result.getPurchaseDate());
	}

	@Test
	void testShorterPassword() {
		Object PasswordUtils;
		assertFalse(PasswordUtils.validatePasswordStrength("aaaa"));
	}



}
