package edu.lev.exceptions.service;

import edu.lev.exceptions.exceptions.CepInvalidoException;

public class FormatadorCepException {

	public static void main(String[] args) {
		try {
			String cepFormatado = formatarCep("2376506");
			System.out.println(cepFormatado);
		} catch (CepInvalidoException e) {
			e.printStackTrace();
			System.out.println("O CEP não corresponde com as regras de negócio!");
		}

	}
	static String formatarCep(String cep) throws CepInvalidoException{
		if (cep.length() != 8) {
			throw new CepInvalidoException();
		}
		return "23.765-064";
	}

}
