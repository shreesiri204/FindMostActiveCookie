package com.activecookie;

import com.activecookie.exception.ServiceException;
import com.activecookie.service.CookieService;
import com.activecookie.util.CLIParser;

public class CookieApplication {

	private static CookieService cookieService = new CookieService();

	public static void main(String[] args) {

		CLIParser.parseInput(args);
		try {
			cookieService.process(CLIParser.getFileName(), CLIParser.getDate());
		} catch (ServiceException exp) {
			System.out.println("Exception : " + exp.getMessage());
		}

	}

}
