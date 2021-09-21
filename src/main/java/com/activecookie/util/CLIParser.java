package com.activecookie.util;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class CLIParser {

	@Parameter(names = { "--fileName", "-f" }, required = true, description = "CSV File name")
	static String fileName;

	@Parameter(names = { "--date", "-d" }, required = true, description = "Date in UTC timeZone")
	static String date;

	@Parameter(names = "--help", help = true)
	private boolean help;

	public static void parseInput(String[] args) {
		CLIParser inputArguments = new CLIParser();
		JCommander jct = JCommander.newBuilder().addObject(inputArguments).build();
		try {
			jct.parse(args);
		} catch (ParameterException e) {
			jct.usage();
			System.exit(0);
		}
		if (inputArguments.help) {
			jct.usage();
			System.exit(0);
		}

	}

	public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		CLIParser.fileName = fileName;
	}

	public static String getDate() {
		return date;
	}

	public static void setDate(String date) {
		CLIParser.date = date;
	}

}
