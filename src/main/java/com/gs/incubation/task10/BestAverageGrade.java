package com.gs.incubation.task10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAverageGrade {

    public static Integer bestAverageGrade(String[][] scores) {
        if (scores == null || scores.length == 0) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        Integer maxAverage = 0;
        Map<String, List<Integer>> studentScores = new HashMap<>();
        for (String[] student : scores) {
            if (studentScores.containsKey(student[0])) {
                studentScores.get(student[0]).add(Integer.parseInt(student[1]));
            } else {
                List<Integer> scoresList = new ArrayList<>();
                scoresList.add(Integer.parseInt(student[1]));
                studentScores.put(student[0], scoresList);
            }
        }
        for (Map.Entry<String, List<Integer>> entry : studentScores.entrySet()) {
            double average = entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0);
            if (maxAverage < (int) average) {
                maxAverage = (int) average;
            }
        }
        return maxAverage;
    }

    public static void main(String[] args) {
        String[][] scores = {{"Bobby", "87"},
                {"Charles", "100"},
                {"Eric", "64"},
                {"Charles", "22"}};
        System.out.println(bestAverageGrade(scores));
    }
}
