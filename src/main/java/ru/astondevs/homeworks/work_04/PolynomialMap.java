package ru.astondevs.homeworks.work_04;

import java.util.*;


public class PolynomialMap implements Polynomial {
    private final Map<Integer, Double> map = new HashMap<>();

    PolynomialMap(Map<Integer, Double> polynom) {
        map.putAll(polynom);
    }

    PolynomialMap(String polynom) {
        String poly = sanitizeString(polynom);
        String[] monomials = parseMonomials(poly);
        String signs = parseSigns(poly, monomials.length);

        fillMap(signs, monomials);
    }

    PolynomialMap() {}

    @Override
    public Map<Integer, Double> toTable() {
        return Map.copyOf(map);
    }

    @Override
    public Set<Integer> getDegrees() {
        return Set.copyOf(map.keySet());
    }

    @Override
    public double getMultiplier(int degree) {
        return map.get(degree);
    }

    @Override
    public void add(Polynomial other) {
        map.putAll(other.toTable());
    }

    @Override
    public void sanitize() {
        map.keySet().stream()
                .filter(key -> map.get(key) == 0)
                .toList()
                .forEach(map::remove);
    }

    @Override
    public String toString() {
        StringBuilder polynomial = new StringBuilder();

        List<Integer> degrees = map.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        for (int i = 0; i < degrees.size(); i++) {
            int deg = degrees.get(i);
            double mul = map.get(deg);

            double absMul = Math.abs(mul);

            String sign ="";
            String multiplier = "";
            String varDegree = "";

            if (i == 0) {
                sign = "";

                if (absMul != 1) {
                    multiplier = mul % 1 == 0
                            ? String.format("%d", (int) mul)
                            : String.format("%.2f", mul);
                }

            } else {
                sign = mul > 0
                        ? " + "
                        : " - ";

                if (absMul != 1) {
                    multiplier = mul % 1 == 0
                            ? String.format("%d", (int) absMul)
                            : String.format("%.2f", absMul);
                }
            }

            varDegree = switch (deg) {
                case 0 -> "";
                case 1 -> "x";
                default -> "x^" + deg;
            };

            polynomial
                    .append(sign)
                    .append(multiplier)
                    .append(varDegree);
        }

        return polynomial.toString();
    }

    private String sanitizeString(String source) {
        return source.replaceAll(" ", "");
    }

    private String parseSigns(String source, int memberCount) {
        String signs = source.replaceAll("[^-+]", "");

        return signs.length() == memberCount
                ? signs
                : "+" + signs;
    }

    private String[] parseMonomials(String source) {
        String[] tokens = source.split("[-+]");

        return tokens[0].isEmpty()
                ? Arrays.copyOfRange(tokens, 1, tokens.length)
                : tokens;
    }

    private void fillMap(String signs, String[] monomials) {
        for (int i = 0; i < monomials.length; i++) {
            String mono = monomials[i];
            char sign = signs.charAt(i);

            int deg;
            double mul;

            if (!mono.contains("x")) {
                deg = 0;
                mul = Double.parseDouble(sign + mono);

            } else if (mono.equals("x")) {
                deg = 1;
                mul = Double.parseDouble(sign + "1");;

            } else {
                String[] tokens = mono.split("x\\^|x");

                mul = tokens[0].isEmpty()
                        ? Double.parseDouble(sign + "1")
                        : Double.parseDouble(sign + tokens[0]);

                deg = tokens.length == 1
                        ? 1
                        : Integer.parseInt(tokens[1]);
            }

            map.put(deg, mul);
        }
    }
}
