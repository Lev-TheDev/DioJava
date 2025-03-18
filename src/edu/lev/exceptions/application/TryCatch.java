package edu.lev.exceptions.application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class TryCatch {

	public static void main(String[] args) {
		try {
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
		// nullpointer = acesso a variável nula;
		// arithmetic = dividir um valor por zero
		// sql = erro na interação com banco de dados
		// filenotfound = ler ou escrever em arquivo inexistente
		}
		catch (InputMismatchException e) {
			System.out.println("Os campos idade e altura precisam ser numéricos!");
			// System.err.println("Os campos idade e altura precisam ser numéricos!");
		}

	}

}
