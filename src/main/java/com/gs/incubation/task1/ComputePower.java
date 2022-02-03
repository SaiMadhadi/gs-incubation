package com.gs.incubation.task1;

public class ComputePower {

    private double powerCalculation(double base, int exp) {
        double value;
        if (exp == 0) {
            return 1;
        } else if (exp == 1) {
            return base;
        } else {
            value = powerCalculation(base, exp / 2);
            if (exp % 2 == 0) {
                return value * value;
            } else {
                return base * value * value;
            }
        }
    }

    public double power(double base, int exp) {
        double ans;
        if (exp < 0) {
            ans = 1 / powerCalculation(base, -exp);
        } else {
            ans = powerCalculation(base, exp);
        }
        return ans;
    }
}
