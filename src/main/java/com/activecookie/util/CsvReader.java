package com.activecookie.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

import com.activecookie.exception.ServiceException;
import com.activecookie.model.CookieLog;
import java.time.LocalDate;

public class CsvReader {

	private static final String SEPARATOR = ",";

	/**
	 * 
	 * @param inputArgs
	 * @return
	 * @throws ServiceException
	 */
	public static Map<String, Long> readCsv(String fileName, String date) throws ServiceException {
		Path path = Paths.get(fileName);
		if (Files.exists(path)) {
			try (BufferedReader br = Files.newBufferedReader(path)) {
				Map<String, Long> groupByCookie = br.lines().skip(1).map(line -> line.split(SEPARATOR))
						.map(arr -> new CookieLog(arr[0], arr[1]))
						.filter(list -> list.getTimestamp().toLocalDate().equals(LocalDate.parse(date)))
						.collect(Collectors.groupingBy(CookieLog::getCookie, Collectors.counting()));
				return groupByCookie;

			} catch (IOException e) {
				throw new ServiceException(e.getMessage());
			}
		} else {
			throw new ServiceException("File not Found");
		}
	}

}
