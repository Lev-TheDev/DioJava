package edu.lev.poo.interfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MainInterfaceFunctional {
	
	public static void main(String[] args) {
		List<User> users = List.of(new User("Maria", 21), new User("João", 32),
				new User("Eduardo", 40), new User("Ana", 19));
	
	//v1
		var consumer = new Consumer<User>() {

			@Override
			public void accept(User user) {
				System.out.println(user);
			}
		};
		users.forEach(consumer);
	//v2
		users.forEach(new Consumer<User>() {

			@Override
			public void accept(User user) {
				System.out.println(user);
			}
		});
	//v3
		users.forEach((User user) -> {
				System.out.println(user);
			});
	//v4
		users.forEach(user -> System.out.println(user));
	//v5
		users.forEach(System.out::println);
	// expressão criada
		printStringValue(User::name, users);
	}
	
	private static void printStringValue(Function<User, String> callback, List<User> users) {
		users.forEach(u -> System.out.println(callback.apply(u)));
	}
}
