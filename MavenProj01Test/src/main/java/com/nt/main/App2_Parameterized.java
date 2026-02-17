package com.nt.main;

public class App2_Parameterized {
	public double add(double a, double b) {
		return a + b;
	}

	public boolean isPallendrome(String str) {
		String revstr = new StringBuffer(str).reverse().toString();
		return str.equals(revstr);
	}
}