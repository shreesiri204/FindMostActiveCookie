package com.activecookie.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
	public static List<CookieLog> readCSVForInputDate(String fileName, String date) throws ServiceException {
		Path path = Paths.get(fileName);
		if (Files.exists(path)) {
			try (BufferedReader br = Files.newBufferedReader(path)) {
				List<CookieLog> cookieLogList = br.lines().skip(1).map(line -> line.split(SEPARATOR))
						.map(arr -> new CookieLog(arr[0], arr[1]))
						.dropWhile(list -> list.getTimestamp().toLocalDate().isBefore(LocalDate.parse(date)))
						.filter(list -> list.getTimestamp().toLocalDate().equals(LocalDate.parse(date)))
						.collect(Collectors.toList());
				return cookieLogList;

			} catch (IOException e) {
				throw new ServiceException(e.getMessage());
			}
		} else {
			throw new ServiceException("File not Found");
		}
	}

}
