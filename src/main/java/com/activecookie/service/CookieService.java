package com.activecookie.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import com.activecookie.exception.ServiceException;
import com.activecookie.model.CookieLog;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import static com.activecookie.util.CsvReader.readCSVForInputDate;

public class CookieService {

	public void process(String fileName, String date) throws ServiceException {
		List<CookieLog> cookieLogs = readCSVForInputDate(fileName, date);
		final Map<String, Long> groupByCookie = groupCookieForInputDate(LocalDate.parse(date), cookieLogs);
		final OptionalLong maxActiveCookieSize = getMaxActiveCookieSize(groupByCookie);
		maxActiveCookieSize.ifPresent(size -> printMostActiveCookies(groupByCookie, size));
	}

	private Map<String, Long> groupCookieForInputDate(LocalDate inputDate, List<CookieLog> cookieLogs) {
		return cookieLogs.stream().collect(groupingBy(CookieLog::getCookie, counting()));

	}

	private OptionalLong getMaxActiveCookieSize(Map<String, Long> groupByCookie) {
		return groupByCookie.values().stream().mapToLong(count -> count).max();

	}

	private void printMostActiveCookies(Map<String, Long> groupByCookie, long maxActiveCookieSize) {
		groupByCookie.entrySet().stream().filter(v -> v.getValue().equals(maxActiveCookieSize)).map(Map.Entry::getKey)
				.forEach(System.out::println);
	}

}
