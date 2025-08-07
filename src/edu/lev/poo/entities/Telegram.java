package edu.lev.poo.entities;

import edu.lev.poo.service.ServicoMensagemInstantanea;

public class Telegram extends ServicoMensagemInstantanea{

	@Override
	public void enviarMensagem() {
		validarConectadoInternet();
		System.out.println("Enviando mensagem pelo Telegram...");
		salvarHistoricoMensagem();
	}

	@Override
	public void receberMensagem() {
		System.out.println("Recebendo mensagem pelo Telegram...");
		salvarHistoricoMensagem();		
	}

	@Override
	public void salvarHistoricoMensagem() {
		System.out.println("Salvando histórico de mensagens do Telegram...");
		
	}

}
