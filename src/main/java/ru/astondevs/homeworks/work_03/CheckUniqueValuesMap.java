package ru.astondevs.homeworks.work_03;

import java.util.Map;


public class CheckUniqueValuesMap {
    private CheckUniqueValuesMap() {
        throw new AssertionError();
    }

    public static boolean in(Map<String, String> target) {
        int realValueCount = target
                .values()
                .size();

        long uniqueValueCount = target
                .values()
                .stream()
                .distinct()
                .count();

        return realValueCount == uniqueValueCount;
    }
}
