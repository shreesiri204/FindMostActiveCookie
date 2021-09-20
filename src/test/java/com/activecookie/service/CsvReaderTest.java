package com.activecookie.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.activecookie.exception.ServiceException;
import com.activecookie.util.CsvReader;

class CsvReaderTest {
	
	private CsvReader csvReader = new CsvReader();

	@Test
	void execute_checkCookieObjectListSize() throws ServiceException {
		assertEquals((csvReader.readCSVForInputDate("src/test/resources/cookie.csv", "2018-12-09")).size(),5);
	}
	
	@Test
	void execute_checkNoCookieforGivenDate() throws ServiceException {
		assertEquals((csvReader.readCSVForInputDate("src/test/resources/cookie.csv", "2018-12-11")).size(),0);
	}

}
