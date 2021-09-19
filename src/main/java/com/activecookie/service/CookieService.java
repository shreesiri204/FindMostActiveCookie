package com.activecookie.service;

import java.util.Map;
import java.util.OptionalLong;

import com.activecookie.exception.ServiceException;

import static com.activecookie.util.CsvReader.readCsv;

public class CookieService implements ICookieService {

	@Override
	public void process(String[] inputArgs) throws ServiceException {
		Map<String, Long> cookieLogs =  readCsv(inputArgs);
        final OptionalLong maxActiveCookieSize = getMaxActiveCookieSize(cookieLogs);
        maxActiveCookieSize.ifPresent(
                size -> printMostActiveCookies(cookieLogs, size)
        );

	}
	
	public static OptionalLong getMaxActiveCookieSize(Map<String, Long> groupByCookie) {
        return groupByCookie
                .values()
                .stream()
                .mapToLong(count -> count)
                .max();
    }

    public static void printMostActiveCookies(Map<String, Long> groupByCookie, long maxActiveCookieSize) {
        groupByCookie
                .entrySet()
                .stream()
                .filter(v -> v.getValue().equals(maxActiveCookieSize))
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

}
