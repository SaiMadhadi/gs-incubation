package com.gs.incubation.task1;

public class DotProduct {

    public long dotProduct(int[] array1, int[] array2) {
        if (array1 == null || array2 == null || array1.length != array2.length)
            throw new IllegalArgumentException("Input is invalid");
        long dotProduct = 0;
        int length = array1.length;
        for (int i = 0; i < length; i++) {
            dotProduct += array1[i] * array2[i];
        }
        return dotProduct;
    }
}
