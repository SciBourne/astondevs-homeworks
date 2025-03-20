package ru.astondevs.homeworks.work_04;

import java.util.Map;
import java.util.Set;


public interface Polynomial {
    static Polynomial of(Map<Integer, Double> source) {
        return new PolynomialMap(source);
    }

    static Polynomial of(String source) {
        return new PolynomialMap(source);
    }

    static Polynomial of() {
        return new PolynomialMap();
    }

    Map<Integer, Double> toTable();
    Set<Integer> getDegrees();
    double getMultiplier(int degree);
    void add(Polynomial other);
    void sanitize();
}
