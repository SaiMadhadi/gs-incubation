package com.gs.incubation.task6;

import java.util.ArrayList;
import java.util.List;

public class HashMapImpl {

    private static class Entry<K, V> {

        private final K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class HashMap<K, V> {

        private List<List<Entry<K, V>>> entryList;

        HashMap() {
            this.entryList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                entryList.add(new ArrayList<>());
            }
        }

        public void put(K key, V value) {
            if (key == null || value == null) {
                return;
            }
            Entry<K, V> entryToBeUpdatedOrInserted = null;
            List<Entry<K, V>> list = this.entryList.get(key.hashCode() % entryList.size());
            for (Entry<K, V> e : list) {
                if (key.equals(e.key)) {
                    entryToBeUpdatedOrInserted = e;
                    break;
                }
            }
            if (entryToBeUpdatedOrInserted == null) {
                entryToBeUpdatedOrInserted = new Entry<>(key, value);
                list.add(entryToBeUpdatedOrInserted);
            } else {
                entryToBeUpdatedOrInserted.value = value;
            }
        }

        public V get(K key) {
            if (key == null) {
                return null;
            }
            V value = null;
            List<Entry<K, V>> list = this.entryList.get(key.hashCode() % entryList.size());
            for (Entry<K, V> entry : list) {
                if (key.equals(entry.key)) {
                    value = entry.value;
                    break;
                }
            }
            return value;
        }
    }

    public void doTestsPass() {
        int[][] testCases = {{1, 2}, {3, 4}, {5, 6}, {1, 7}, {1, 8}};
        boolean passed = true;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] test : testCases) {
            Integer key = test[0];
            Integer value = test[1];
            map.put(key, value);
            if (!value.equals(map.get(key))) {
                System.out.println("Test failed [" + key + "," + value + "]");
                passed = false;
            }
        }
        HashMap<String, String> strMap = new HashMap<>();
        String[][] strTestCases = {{"one", "two"}, {"three", "four"}, {"one", "five"}};
        for (String[] test : strTestCases) {
            String key = test[0];
            String value = test[1];
            strMap.put(key, value);
            if (!value.equals(strMap.get(key))) {
                System.out.println("Test failed [" + key + "," + value + "]");
                passed = false;
            }
        }
        if (passed) {
            System.out.println("All tested passed");
        }
    }

    public static void main(String[] args) {
        new HashMapImpl().doTestsPass();
    }
}
