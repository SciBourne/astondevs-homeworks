package ru.astondevs.homeworks;

import ru.astondevs.homeworks.work_01.OddValuesList;
import ru.astondevs.homeworks.work_02.UniqueValueCount;
import ru.astondevs.homeworks.work_03.CheckUniqueValuesMap;
import ru.astondevs.homeworks.work_04.PolynomUtils;

import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        printWork01();
        printWork02();
        printWork03();
        printWork04();
    }

    static void printWork01() {
        System.out.printf(
                "Задание 1: %s\n",

                OddValuesList.from(
                        List.of(1, 2, 3, 4, 5)
                )
        );
    }

    static void printWork02() {
        System.out.printf(
                "Задание 2: %d\n",

                UniqueValueCount.from(
                        List.of(1, 1, 2, 3, 4, 4, 5)
                )
        );
    }

    static void printWork03() {
        System.out.printf(
                "Задание 3: %s, %s\n",

                CheckUniqueValuesMap.in(
                        Map.of(
                                "A", "1",
                                "B", "2",
                                "C", "3"
                        )
                ),

                CheckUniqueValuesMap.in(
                        Map.of(
                                "A", "1",
                                "B", "2",
                                "C", "1"
                        )
                )
        );
    }

    static void printWork04() {
        System.out.printf(
                "Задание 4: %s\n",

                PolynomUtils.sum(
                        "-2x^6 + 3.92x^4 - 4x^3 + x + 12",
                        "1.55x^6 - 2x + x^4 + 2.18x^5 + 4x^3 - 6x^2 - 7"
                )
        );
    }
}
