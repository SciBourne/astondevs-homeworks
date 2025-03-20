package ru.astondevs.homeworks.work_02;

import java.util.List;


public class UniqueValueCount {
    private UniqueValueCount() {
        throw new AssertionError();
    }

    public static long from(List<Integer> source) {
        return source
                .stream()
                .distinct()
                .count();
    }
}
