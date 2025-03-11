package edu.lev.operators.application;

public class Operators {

	public static void main(String[] args) {
		String concatenacao = "?";
		concatenacao = "1"+(1+1+1);
		System.out.println(concatenacao);
		
		int numero = 5;
		numero = - numero; // -5
		System.out.println(numero);
		
		numero = + numero; // -5 pois o + é operador de soma
		numero = numero * -1; // 5 o * converte em positivo
		System.out.println(numero);
		
		int a, b;
		
		a = 5;
		b = 6;
		
		String resultado = "";
		if (a==b) {
			resultado = "verdadeiro";
		} else {
			resultado = "falso";
		}
		System.out.println(resultado);
		
		// ou usando operador ternário
		
		String result = a==b ?"verdadeiro" : "falso";
		System.out.println(result);
		
		int resolut = a==b ? 1 : 0;
		System.out.println(resolut);
		
		int numero1 = 1;
		int numero2 = 2;
		boolean simNao = numero1 == numero2;
		System.out.println("numero1 é igual a numero2? " + simNao);
		
		// método equals compara conteúdos dos objetos ou textos
		
		String nomeUm = "Carlos";
		String nomeDois = new String("Carlos");
		System.out.println(nomeUm == nomeDois);
		System.out.println(nomeUm.equals(nomeDois));
		
		boolean condicao1 = true;
		boolean condicao2 = false;
		if (condicao1 && condicao2) {
			System.out.println("Ambas são verdadeiras!");
		}
		if (condicao1 || condicao2) {
			System.out.println("Uma é verdadeira!");
		}
		
		condicao2 = true;
		if (condicao1 && condicao2) {
			System.out.println("Ambas são verdadeiras!");
		}
		if (condicao1 || condicao2) {
			System.out.println("Uma é verdadeira!");
		}
		
		String res = condicao1 && condicao2 ? "Ambas são verdadeiras!" : "Uma é verdadeira!";
		System.out.println(res);
		// é um teste de expressão verdadeira
		System.out.println("Fim!");

		
		
	}
}
