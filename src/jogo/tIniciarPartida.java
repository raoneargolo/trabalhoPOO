package jogo;

import java.net.Socket;

public class tIniciarPartida {
	Socket cliente1=null;
	Socket cliente2=null;
	Jogador objJogador1=null;
	Jogador objJogador2=null;
	
	public tIniciarPartida() {

	}
	
	public String iniciarPartida(Socket cliente, Jogador objJogador) {
		if(objJogador1==null) {
			this.objJogador1=objJogador;
			this.cliente1=cliente;
			return "aguarde";
		}else {
			this.objJogador2=objJogador;
			this.cliente2=cliente;
			return "comecou";
		}
	}

}
