package com.gs.incubation.task2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FractionToDecimal {

    public static String vulgarToDecimal(Long numerator, Long denominator) {
        StringBuilder quotient = new StringBuilder();
        if (numerator == null || denominator == null || denominator == 0) {
            throw new IllegalArgumentException("Invalid i/p passed");
        } else if (numerator == 0) {
            quotient.append("0");
        } else {
            if (numerator < 0 && denominator > 0) {
                quotient.append("-");
                numerator = -numerator;
            } else if (numerator > 0 && denominator < 0) {
                quotient.append("-");
                denominator = -denominator;
            } else if (numerator < 0 && denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
            Map<Long, Integer> quotientPosition = new HashMap<>();
            Set<Long> remainderSet = new HashSet<>();
            if (numerator < denominator)
                quotient.append("0");
            boolean isFirstTime = true;
            do {
                if (numerator < denominator) {
                    if (isFirstTime) {
                        quotient.append(".");
                        isFirstTime = false;
                    }
                    numerator = numerator * 10;
                    while (numerator < denominator) {
                        numerator = numerator * 10;
                        quotient.append("0");
                    }
                }
                long val = numerator / denominator;
                if (remainderSet.contains(val)) {
                    int pos = quotientPosition.get(val);
                    quotient.insert(pos, "(");
                    quotient.insert(quotient.length(), ")");
                    break;
                } else {
                    quotient.append(val);
                    if (!isFirstTime) {
                        quotientPosition.put(val, quotient.length() - 1);
                        remainderSet.add(val);
                    }
                }
                numerator = numerator % denominator;
            } while (numerator != 0);

        }
        return quotient.toString();
    }
}
