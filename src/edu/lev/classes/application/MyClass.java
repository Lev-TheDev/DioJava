package edu.lev.classes.application;

public class MyClass {

	public static void main(String[] args) {
		System.out.println("Olá, turma. Sejam bem-vindos!");
		
		final String BR = "Brasil";
		
		String nome = "Jhonathan";
		String sobrenome = "Levino";
		System.out.println(nomeCompleto(nome, sobrenome));

	}
	
	public static String nomeCompleto (String nome, String sobrenome) {
		//return nome + " " + sobrenome;
		return nome.concat(" ").concat(sobrenome);
	}
	
	// iniciar pacotes usando "com" (comercial) com.application
	// uma empresa chamada HyperTech um projeto de notificação eu faria como?
	// com.hypertech.notification.application
	// iniciar usando org (organizacional) org.application
	// iniciar usando opensource
	// para aprendizado usar edu.levino.tema

}
