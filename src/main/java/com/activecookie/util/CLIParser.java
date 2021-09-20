package com.activecookie.util;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class CLIParser {

	@Parameter(names = { "--fileName", "-f" }, description = "CSV File name")
	static String fileName;

	@Parameter(names = { "--date", "-d" }, description = "Date in UTC timeZone")
	static String date;

	public static void parseInput(String[] args) {
		CLIParser inputArgumnets = new CLIParser();
		JCommander.newBuilder().addObject(inputArgumnets).build().parse(args);

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
