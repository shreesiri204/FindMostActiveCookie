package com.activecookie;


import com.activecookie.exception.ServiceException;
import com.activecookie.service.CookieService;
import com.activecookie.service.ICookieService;
import com.activecookie.util.CLIParser;

public class CookieApplication {
	
	private static ICookieService cookieService = new CookieService();
	public static void main(String[] args) {
		
		String[] inputArgs = CLIParser.parseInput(args);
		try {
		cookieService.process(inputArgs);
		}catch (ServiceException | RuntimeException exp) {
           System.out.println("Cannot process: Check Input CSV path and content");
        }

	}

}
