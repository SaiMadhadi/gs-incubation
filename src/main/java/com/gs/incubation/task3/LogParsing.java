package com.gs.incubation.task3;

import java.util.LinkedHashMap;
import java.util.Map;

public class LogParsing {

    public static String findTopIpAddress(String[] lines) {
        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        Map<String, Integer> ipAddressCounter = new LinkedHashMap<>();
        for (String line : lines) {
            String ipAddress = line.split(" ")[0];
            if (ipAddressCounter.containsKey(ipAddress)) {
                ipAddressCounter.put(ipAddress, ipAddressCounter.get(ipAddress) + 1);
            } else {
                ipAddressCounter.put(ipAddress, 1);
            }
        }
        StringBuilder maxFrequentIp = new StringBuilder();
        int maxFrequency = -1;
        for (Map.Entry<String, Integer> entry : ipAddressCounter.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                maxFrequentIp.setLength(0);
                maxFrequentIp.append(entry.getKey());
            } else if (entry.getValue() == maxFrequency) {
                maxFrequentIp.append("," + entry.getKey());
            }
        }
        return maxFrequentIp.toString();
    }
}
