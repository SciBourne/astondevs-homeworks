package ru.astondevs.homeworks.work_01;

import java.util.List;
import java.util.stream.Collectors;


public class OddValuesList {
    private OddValuesList() {
        throw new AssertionError();
    }

    public static List<Integer> from(List<Integer> source) {
        return source
                .stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());
    }
}
