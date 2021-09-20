package com.activecookie.service;

import com.activecookie.exception.ServiceException;

public interface ICookieService {
	void process(String fileName, String date) throws ServiceException;

}
