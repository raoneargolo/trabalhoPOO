package jogo;

import java.net.Socket;

public class tIniciarPartida {
	Socket cliente1=null;
	Socket cliente2=null;
	private Jogador objJogador1=null;
	private Jogador objJogador2=null;
	private int cont=0;
	
	public tIniciarPartida() {

	}
	
	public Socket getCliente1() {
		return cliente1;
	}	

	public Socket getCliente2() {
		return cliente2;
	}

	public Jogador getObjJogador1() {
		return objJogador1;
	}

	public Jogador getObjJogador2() {
		return objJogador2;
	}	
	
	public String iniciarPartida(Socket cliente, Jogador objJogador) {
		if(cont==0) {
			this.objJogador1=objJogador;
			this.cliente1=cliente;
			cont++;
			return "aguarde";
		}else {
			this.objJogador2=objJogador;
			this.cliente2=cliente;
			cont++;
			return "comecou";
		}
	}
	
	public boolean verificarComecou() {
		if (cont==2) {
			return false;
		}else {
			return true;
		}
	}
	
	public void finalizarPartida() {
		cont-=2;
	}

}
