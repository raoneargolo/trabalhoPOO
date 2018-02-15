package jogo;

import java.util.List;

public class Usuario {
String usuario;
String senha;
String cor;

public String getCor() {
	return cor;
}
public void setCor(String cor) {
	this.cor = cor;
}
List<Jogo> listaDeJogos;

public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}

	public Usuario(String usuario, String senha , List<Jogo> listaDeJogos ) {
		this.usuario = usuario;
		this.senha = senha;
		this.listaDeJogos=listaDeJogos;
		
	}
	
	public void setPartida(Jogo partida) {
		this.listaDeJogos.add(partida);
	}

}