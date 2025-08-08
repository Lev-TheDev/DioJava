package edu.lev.collections;

import java.util.HashMap;
import java.util.Map;

public class MapHash {
    public static void main(String[] args) {
        Map<String, UserRecord> users = new HashMap<>();
        // LinkedHashMap = ordem de inserção
        // TreeMap = ordem natural (alfabética) ou ordem definida por um Comparator
        // Hashtable = sincronizado, não permite null como chave ou valor
        users.put("joao@gmail.com", new UserRecord("Joao", 25));
        users.put("maria@gmail.com", new UserRecord("Maria", 30));
        users.put("juca@gmail.com", new UserRecord("Juca", 28));
        users.put("leo@gmail.com", new UserRecord("Leo", 22));
        System.out.println(users);
        System.out.println("================");
        users.keySet().forEach(System.out::println);
        System.out.println("================");
        users.values().forEach(System.out::println);
        System.out.println("================");
        System.out.println(users.containsValue(new UserRecord("Joao", 25)));
        System.out.println("========without replace========");
        users.forEach((key, value) -> System.out.printf("key: %s | value: %s \n", key, value));
        users.replace("joao@gmail.com", new UserRecord("Joao", 70));
        System.out.println("========with replace========");
        users.forEach((key, value) -> System.out.printf("key: %s | value: %s \n", key, value));
        System.out.println(users.isEmpty());

    }
}
