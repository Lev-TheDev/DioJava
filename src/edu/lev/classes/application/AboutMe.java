package edu.lev.classes.application;

import java.util.Locale;
import java.util.Scanner;

public class AboutMe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		System.out.println("Digite seu nome: ");
		String nome = sc.next();
		
		System.out.println("Digite seu sobrenome: ");
		String sobrenome = sc.next();
		
		System.out.println("Digite sua idade: ");
		int idade = sc.nextInt();
		
		System.out.println("Digite sua altura: ");
		double altura = sc.nextDouble();
		
		System.out.println("Olá, me chamo " + nome + " " + sobrenome + ".");
		System.out.println("Tenho " + idade + " anos.");
		System.out.println("Minha altura é " + altura + "cm.");
	}
}
