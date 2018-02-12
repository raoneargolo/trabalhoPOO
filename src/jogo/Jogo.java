package jogo;

public class Jogo {

String usuario;
int ordem;
int statusDoJogo; // 1=vitoria 2= empate 3=derrota

	public Jogo(String usuario, int ordem, int statusDoJogo) {
		this.usuario = usuario;
		this.ordem = ordem;
		this.statusDoJogo = statusDoJogo;
	}

}
