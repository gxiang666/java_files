package com.demos.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static String DATE_FORMAT = "yyyy-MM-dd";
	
	public static String formatDateTime(Date d) {
		return new SimpleDateFormat(DATETIME_FORMAT).format(d);
	}
	
	public static String formatDate(Date d) {
		return new SimpleDateFormat(DATE_FORMAT).format(d);
	}
	public static Date parseDate(String date) throws ParseException {
		return new SimpleDateFormat(DATE_FORMAT).parse(date);
	}
	public static Date parseDateTime(String date) throws ParseException {
		return new SimpleDateFormat(DATETIME_FORMAT).parse(date);
	}
	public static String formatDateCustom(Date d,String format) {
		return new SimpleDateFormat(format).format(d);
	}
	public static void main(String[] args) {
		try {
			
			
			Date d1 = new Date();
			String s = DateUtil.formatDate(d1)+" 23:59:59";
			Date d = DateUtil.parseDateTime(s);
			System.out.println(s);
			
			long n = d.getTime() - d1.getTime();
			long m = (long)((d.getTime() - d1.getTime())/1000);
			System.out.println(n);
			System.out.println(m);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
