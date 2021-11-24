package com.gs.incubation.task2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SquareRoot {

    private static double findIntegralPartOfSquareRoot(double num) {
        double low = 0, high = num;
        int mid = 0;
        while (low < high) {
            mid = (int) (low + high) / 2;
            if (mid * mid == num) {
                return mid;
            } else if (num > mid * mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return mid;
    }

    private static double findDecimalPartOfSquareRoot(double integralPart, double num) {
        double low = integralPart, high = integralPart + 1, precision = 0.0000001, mid = 0.0;
        while (low < high) {
            mid = (low + high) / 2;
            double midSquare = BigDecimal.valueOf(mid * mid).setScale(7, RoundingMode.CEILING).doubleValue();
            if (midSquare == num || midSquare == num + precision || midSquare == num - precision) {
                return BigDecimal.valueOf(mid).setScale(7, RoundingMode.CEILING).doubleValue();
            } else if (num > mid * mid) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return BigDecimal.valueOf(mid).setScale(7, RoundingMode.CEILING).doubleValue();
    }

    public static double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Square root doesn't exist for Negative Integers");
        } else if (num == 0 || num == 1) {
            return num;
        } else {
            double integralPart = findIntegralPartOfSquareRoot(num);
            if (integralPart * integralPart == num) {
                return integralPart;
            } else if (integralPart * integralPart > num) {
                return findDecimalPartOfSquareRoot(integralPart - 1, num);
            } else {
                return findDecimalPartOfSquareRoot(integralPart, num);
            }
        }
    }

}
