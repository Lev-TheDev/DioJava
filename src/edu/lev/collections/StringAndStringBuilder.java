package edu.lev.collections;

import java.util.HashMap;
import java.util.Map;

public class StringAndStringBuilder {

    public static void main(String[] args) {
        var value = "java;java;java;java";
        value = value.replaceFirst("j", "J");
        System.out.println(value);

        var values = value.split(";", 2);
        for (var v : values) {
            System.out.println(v);
        }

        System.out.println(value.indexOf("j", 1, 5));
        var str = "  f    ";
        var str2 = "*****programming***";
        System.out.println(str.trim());
        System.out.println(str2.substring(5,16));

        var json = """
                {"name":"João","age":18}""";
        Map<String, String> map = new HashMap<>();
        json = json.replace("{", "").replace("}", "").replace("\"", "");
        var jsonArray = json.split(",");
        for (var v : jsonArray) {
            var keyValue = v.split(":");
            map.put(keyValue[0], keyValue[1]);
        }
        System.out.println(map);
    }

        // toUpperCase - contains - equalsIgnoreCase - trim
        // isEmpty (considera espaços - isBlank (desconsidera espaços)
}
