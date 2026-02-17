package com.nt.main;

public class App {

    public static void main(String[] args) {
        
        double result = calcSimpleInterestAmount(10000, 5, 2);
        System.out.println("Simple Interest = " + result);
    }

    // Method should be outside main
    public static double calcSimpleInterestAmount(double pamt, double rate, double time) {

        if (pamt <= 0 || rate <= 0 || time <= 0) {
            throw new IllegalArgumentException("Invalid Inputs");
        }

        return (pamt * rate * time) / 100;
    }
}