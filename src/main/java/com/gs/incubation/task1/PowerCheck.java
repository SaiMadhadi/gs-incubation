package com.gs.incubation.task1;

public class PowerCheck {

    private static boolean binarySearch(int low, int high, int key) {
        int mid, val;
        while (low <= high) {
            mid = (low + high) / 2;
            val = (int) Math.pow(10, mid);
            if (val == key) {
                return true;
            } else if (val < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static boolean isPowerOf10(int x) {
        if (x == 1)
            return true;
        if (x == 0)
            return false;
        int powersOf10 = 10;
        int range = 1;
        while (powersOf10 < x) {
            powersOf10 *= powersOf10;
            range *= 2;
        }
        return binarySearch(range / 2, range, x);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf10(100000));
    }

}
