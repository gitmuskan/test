package com.tutorialsninja.utils;

import java.util.Date;

public class utilities {
	public static final int IMPLICIT_WAIT_TIME= 10;
	public static final int PAGE_WAIT_TIME=5;
	public   static String generateEmailtimestamp() {
		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		return "muskan"+timestamp+"@gmail.com";
}
}
