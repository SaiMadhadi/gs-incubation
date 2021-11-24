package com.gs.incubation.task2;

import java.util.ArrayList;

public class PrimeFactors {

    public static ArrayList<Integer> primeFactorization(int num) {
        ArrayList<Integer> primeFactorsList = new ArrayList<>();
        if (num == 0 || num == 1) {
            return primeFactorsList;
        } else if (num < 0) {
            throw new IllegalArgumentException("Invalid input given");
        } else {
            while (num % 2 == 0) {
                primeFactorsList.add(2);
                num /= 2;
            }

            for (int i = 3; i <= Math.sqrt(num); i = i + 2) {
                while (num % i == 0) {
                    primeFactorsList.add(i);
                    num /= i;
                }
            }
            if (num > 2) {
                primeFactorsList.add(num);
            }
        }
        return primeFactorsList;
    }
}
