package edu.lev.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class SetNotDuplicate {

    public static void main(String[] args) {
        Set<User> users2 = new TreeSet<>((User u1, User u2) -> {
            var compareResult = 0;
            if (u1.getCode() < u2.getCode()) compareResult --;
            if (u1.getCode() > u2.getCode()) compareResult ++;
            return compareResult;
        }); // ou na lambda do Comparator
        // Set<User> users2 = new TreeSet<>(Comparator.comparing(User::getCode).reversed()); // lambda mais simples

        // Exemplo de uso de Set para evitar duplicatas
        // HashSet ordena pelo equals e hashCode
        // LinkedHashSet mantém a ordem de inserção
        // TreeSet ordena os elementos de acordo com a ordem natural ou um comparador fornecido
        Set<User> users = new HashSet<>();

        users.add(new User(2, "Maria"));
        users.add(new User(3, "João"));
        users.add(new User(1, "Ana"));
        users.add(new User(3, "João")); // Duplicata
        // Não será adicionado, pois já existe um usuário com o mesmo código

        System.out.println("Tamanho do conjunto: " + users.size()); // Deve imprimir 2
        users.forEach(System.out::println); // Imprime os usuários únicos
        System.out.println("==============");
        users.removeIf(Predicate.not(u -> u.getCode() > 2));
        var iterator = users.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // iterator é mesma coisa que forEach
        System.out.println(users.contains(new User(3, "João"))); // true, porque o equals foi sobrescrito
    }
}
