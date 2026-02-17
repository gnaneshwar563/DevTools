package com.nt.main;

import java.time.LocalDate;

public class StringUtil {
	public static boolean isPallendrome(String str) {

		if (str == null || str.equalsIgnoreCase("") || str.length() == 0) {
			throw new IllegalArgumentException("Invalid");
		}
		String reversed = new StringBuilder(str).reverse().toString();
		return str.equals(reversed);
	}

	public LocalDate createDate(int year, int month, int day) {

		if (year < 1900 || month < 0 || day <= 0) {
			return null;
		} else {
			return LocalDate.of(year, month, day);
		}
	}
}
