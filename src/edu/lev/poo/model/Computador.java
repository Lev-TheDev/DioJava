package edu.lev.poo.model;

import edu.lev.poo.entities.FacebookMessenger;
import edu.lev.poo.entities.MSNMessenger;
import edu.lev.poo.entities.Telegram;
import edu.lev.poo.service.ServicoMensagemInstantanea;

public class Computador {

	public static void main(String[] args) {
		ServicoMensagemInstantanea smi = null;
		
		String appEscolhido = "MSN";
		
		if (appEscolhido.equalsIgnoreCase("msn")) {
			smi = new MSNMessenger();
		} else if (appEscolhido.equalsIgnoreCase("facebook")) {
			smi = new FacebookMessenger();
		} else if (appEscolhido.equalsIgnoreCase("telegram")) {
			smi = new Telegram();
		}
		
		smi.enviarMensagem();
		smi.receberMensagem();
	}

}
