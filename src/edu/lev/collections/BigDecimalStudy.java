package edu.lev.collections;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalStudy {

    public static void main(String[] args) {
        var valuee1 = 0.1f;
        var valuee2 = 0.2f;
        System.out.println(valuee1 + valuee2); // 0.30000000000000004
        System.out.println("=============");

        System.out.println(2.00f - 1.1f);
        System.out.println(2.00f - 1.2f);
        System.out.println(2.00f - 1.3f);
        System.out.println(2.00f - 1.4f);

        System.out.println("=============");
        var value1 = new BigDecimal("0.1");
        var value2 = new BigDecimal("0.2");
        System.out.println(value1.add(value2)); // 0.3
        System.out.println("=============");

        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.1"))); // 0.9
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.2"))); // 0.8
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.3"))); // 0.7
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.4"))); // 0.6
        System.out.println("=============");

        var valueD1 = new BigDecimal("56.36");
        var valueD2 = new BigDecimal("99.34");
        System.out.println(valueD2.divide(valueD1, 3, RoundingMode.HALF_UP));



    }
}
