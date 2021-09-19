package com.activecookie.util;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class CLIParser {
	
	@Parameter(names={"--fileName", "-f"})
	static String fileName;
    @Parameter(names={"--date", "-d"})
	static String date;

    public static String[] parseInput(String[] args) {
    	CLIParser inputArgumnets = new CLIParser();
        JCommander.newBuilder()
            .addObject(inputArgumnets)
            .build()
            .parse(args);
		
		String[] inputArgs =  {fileName,date};
        return inputArgs;
    }

}
