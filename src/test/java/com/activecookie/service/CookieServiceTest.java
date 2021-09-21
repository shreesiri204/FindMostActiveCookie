package com.activecookie.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import com.activecookie.exception.ServiceException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class CookieServiceTest {

	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final CookieService cookieService = new CookieService();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	void execute_whenContainsSingleMostActiveCookie() throws ServiceException {
		cookieService.process("src/test/resources/cookie.csv", "2018-12-09");
		assertThat(outputStreamCaptor.toString().trim()).contains("AtY0laUfhglK3lC7");

	}

	@Test
	public void execute_whenContainsMoreThanOneActiveCookie() throws ServiceException {

		cookieService.process("src/test/resources/cookieLog.csv", "2018-12-08");
		assertThat(outputStreamCaptor.toString().trim()).contains("SAZuXPGUrfbcn5UA");
		assertThat(outputStreamCaptor.toString().trim()).contains("4sMM2LxV07bPJzwf");
		assertThat(outputStreamCaptor.toString().trim()).contains("fbcn5UAVanZf6UtG");
	}

	@Test
	public void execute_whenGivenArgumentDateNotPresent_thenReturnsEmpty() throws ServiceException {
		cookieService.process("src/test/resources/cookieLog.csv", "2018-12-10");
		assertThat(outputStreamCaptor.toString().trim()).contains("Cookie(s) not Found for given date-2018-12-10");
	}

	@Test
	public void execute_whenFilePathDoesNotExist_thenThrowsServiceException() {

		assertThatThrownBy(() -> cookieService.process("src/test/resources/cookieLog1.csv", "2018-12-10"))
				.isInstanceOf(ServiceException.class);
	}

}
