package edu.lev.repetitions.application;

import java.util.Random;

public class TelefoneTocando {

	public static void main(String[] args) {
		System.out.println("Discando...");
		
		do {
			System.out.println("Telefone tocando... (ring ring)");
		} while (tocando());
		
		System.out.println("Alô?!");
	}
	
	private static boolean tocando() {
		boolean atendeu = new Random().nextInt(3)==1;
		System.out.println("Atendeu? " + atendeu);
		return !atendeu;
	}

}
