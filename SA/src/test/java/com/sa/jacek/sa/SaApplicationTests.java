package com.sa.jacek.sa;

import com.sa.jacek.sa.order.OrderDto;
import com.sa.jacek.sa.order.OrderService;
import com.sa.jacek.sa.user.UserDto;
import com.sa.jacek.sa.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	OrderService orderService;
	@Autowired
	UserService userService;

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
		Assertions.assertNotNull(result.getPurchaseDate());
	}

	@Test
	void shoudAddUser() {
		// given - tworzy użytkownika
		UserDto dto = new UserDto();
		dto.setPassword("aasasasa");
		dto.setEmail("ftfftft@gfgf.pl");
		dto.setLogin("jhjhjhj");
		dto.setDateOfBirth(LocalDate.of(2000, 10, 01 ));

		// when - zapisuje użytkownika
		var result = userService.addUser(dto);

		// then - generuje id użytkownika
		Assertions.assertNotNull(result.getId());

	}

	@Test
	void shoudValidateDateOfBirth() {
		// given + when - podaje użytkownika bez podanej daty urodzenia
		// then - otrzymujemy wyjątek gdy data urodzenia jest zakomentowana

		Exception exception = assertThrows(ConstraintViolationException.class, () -> {
			UserDto dto = new UserDto();
			dto.setPassword("aasasasa");
			dto.setEmail("ftfftft@gfgf.pl");
			dto.setLogin("jhjhjhj");
		//	dto.setDateOfBirth(LocalDate.of(2000, 10, 01 ));

			var result = userService.addUser(dto);
		});

		String expectedMessage = "nie może mieć wartości null";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));


	}
}

