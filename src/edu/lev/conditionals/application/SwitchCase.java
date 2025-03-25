package edu.lev.conditionals.application;

public class SwitchCase {

	public static void main(String[] args) {
		String plano = "M";
		
		switch (plano) {
			case "T": {
				System.out.println("5Gb Youtube");
				//brake;
			}
			case "M": {
				System.out.println("Whats e Instagram grátis");
				//brake;
			}
			case "B": {
				System.out.println("100 minutos de ligação");
				//brake;
			}
			default: {
				System.out.println("Atendimento encerrado!");
			}
		}
	}
// no switch case, quando não usa o BREAK abaixo de cada case
// ele faz o programa continuar a executar o que vem abaixo
	// isso torna possível adicionar progressivamente coisas
	// colocando o que você quer de baixo para cima.
		// conceitos no switch case: BRAKE, DEFAULT, CONTINUE
}
