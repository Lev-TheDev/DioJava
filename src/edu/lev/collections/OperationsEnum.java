package edu.lev.collections;

import java.util.function.BiFunction;

public enum OperationsEnum {
    SUM (Integer::sum, "+" ),
    SUBTRACTION ((Integer v1, Integer v2) -> v1 - v2, "-" ),

    MULTIPLICATION ((Integer v1, Integer v2) -> v1 * v2, "*"),
    DIVISION ((Integer v1, Integer v2) -> v1 / v2, "/");

    private final BiFunction<Integer, Integer, Integer> calculate;

    private final String symbol;

    OperationsEnum(BiFunction<Integer, Integer, Integer> calculate, String symbol) {
        this.calculate = calculate;
        this.symbol = symbol;
    }

    public BiFunction<Integer, Integer, Integer> getCalculate() {
        return calculate;
    }

    public String getSymbol() {
        return symbol;
    }
}
