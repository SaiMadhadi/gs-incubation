package com.gs.incubation.task1;

public class FractionsAddition {

    private int gcdOf(int num1, int num2) {
        if (num2 == 0)
            return num1;
        return gcdOf(num2, num1 % num2);
    }

    public int[] addFractions(int[] fraction1, int[] fraction2) {
        if (fraction1 == null || fraction2 == null || fraction1.length != 2 || fraction2.length != 2)
            throw new IllegalArgumentException("Input is invalid");
        int gcd = gcdOf(fraction1[1], fraction2[1]);
        int lcm = (fraction1[1] * fraction2[1]) / gcd;
        int numerator = (fraction1[0] * (lcm / fraction1[1])) + (fraction2[0] * (lcm / fraction2[1]));
        int denominator = lcm;
        int gcdOfNumeratorAndDenominator = gcdOf(numerator, denominator);
        int[] ans = new int[2];
        ans[0] = numerator / gcdOfNumeratorAndDenominator;
        ans[1] = denominator / gcdOfNumeratorAndDenominator;
        return ans;
    }
}
