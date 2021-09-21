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

/**
 * @author kshree
 *
 */
public class CookieService {

	public void process(String fileName, String date) throws ServiceException {
		List<CookieLog> cookieLogs = readCSVForInputDate(fileName, date);
		if (cookieLogs.size() != 0) {
			final Map<String, Long> groupByCookie = groupCookies(LocalDate.parse(date), cookieLogs);
			final OptionalLong maxActiveCookieSize = getMaxActiveCookieSize(groupByCookie);
			maxActiveCookieSize.ifPresent(size -> printMostActiveCookies(groupByCookie, size));
		} else {
			System.out.println("Cookie(s) not Found for given date-" + date);
		}
	}
	
	
	/**
	 * This method Groups the cookies and counts the occurrence
	 * @param inputDate
	 * @param cookieLogs
	 * @return Map<String, Long> with key as cookie name and value as its occurrence count 
	 */
	private Map<String, Long> groupCookies(LocalDate inputDate, List<CookieLog> cookieLogs) {
		return cookieLogs.stream().collect(groupingBy(CookieLog::getCookie, counting()));

	}

	/**
	 * This method gets most active cookie size
	 * @param groupByCookie
	 * @return
	 */
	private OptionalLong getMaxActiveCookieSize(Map<String, Long> groupByCookie) {
		return groupByCookie.values().stream().mapToLong(count -> count).max();
	
	}

	/**
	 * This method prints the most active cookie(s)
	 * @param groupByCookie
	 * @param maxActiveCookieSize
	 */
	private void printMostActiveCookies(Map<String, Long> groupByCookie, long maxActiveCookieSize) {
		groupByCookie.entrySet().stream().filter(v -> v.getValue().equals(maxActiveCookieSize)).map(Map.Entry::getKey)
				.forEach(System.out::println);
	}

}
