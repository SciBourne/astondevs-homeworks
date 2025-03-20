package ru.astondevs.homeworks.work_04;

import java.util.Set;
import java.util.stream.Collectors;


public class PolynomUtils {
    private PolynomUtils() {
        throw new AssertionError();
    }

    public static Polynomial sum(String first, String second) {
        Polynomial poly1 = Polynomial.of(first);
        Polynomial poly2 = Polynomial.of(second);

        Polynomial polySum = Polynomial.of(
                intersection(poly1, poly2)
                        .stream()
                        .collect(Collectors
                                .toMap(deg -> deg,
                                        deg -> poly1.getMultiplier(deg) +
                                                poly2.getMultiplier(deg)))
        );

        return union(poly1, poly2, polySum);
    }

    public static Set<Integer> intersection(Polynomial first, Polynomial second) {
        return first.getDegrees().stream()
                .filter(second.getDegrees()::contains)
                .collect(Collectors.toSet());
    }

    public static Polynomial union(Polynomial... polynomials) {
        Polynomial unionPoly = Polynomial.of();

        for (Polynomial poly : polynomials) {
            unionPoly.add(poly);
        }

        unionPoly.sanitize();
        return unionPoly;
    }

    public static void main(String[] args) {
        System.out.printf(
                "Задание 4: %s\n",

                PolynomUtils.sum(
                        "-2x^6 + 3.92x^4 - 4x^3 + x + 12",
                        "1.55x^6 - 2x + x^4 + 2.18x^5 + 4x^3 - 6x^2 - 7"
                )
        );
    }
}
