package com.activecookie.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.activecookie.exception.ServiceException;
import com.activecookie.model.CookieLog;
import java.time.LocalDate;




public class CsvReader {
	
	
	  private static final String SEPARATOR = ",";
	  

	  List<String> columns; List<List<String>> values;
	  
	  public static Map<String, Long> readCsv(String[] inputArgs)  throws ServiceException { 
		  Path path = Paths.get(inputArgs[0]);
		  if (Files.exists(path)) { 
			  try(BufferedReader br = Files.newBufferedReader(path)) { 
				  Map<String, Long> groupByCookie = br.lines() 
						  .skip(1) 
						  .map(line ->line.split(SEPARATOR))
						  .map(arr -> new CookieLog(arr[0], arr[1]))
						  .filter(list ->list.getTimestamp().toLocalDate().equals(LocalDate.parse(inputArgs[1])))
						  .collect(Collectors.groupingBy(CookieLog::getCookie, Collectors.counting()));
	           return groupByCookie;
	  
			  } catch (IOException e) {
				e.printStackTrace();
			}
		  }else {
			  throw new ServiceException(null);
		  }
		  
		  return null;
	  }
	
}
