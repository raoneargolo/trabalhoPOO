package jogo;

import javax.swing.JFrame;
import java.io.Serializable;

public class ControlaJogo implements Serializable{
	int contadorJogadas=0;
	public boolean checkMatriz(int matriz[][],int button, int valor) {
		boolean resposta=false;
		if(button==1) {
			if((matriz[1][0]==valor&&matriz[2][0]==valor) || (matriz[0][1]==valor&&matriz[0][2]==valor) || (matriz[1][1]==valor&&matriz[2][2]==valor)) {
				resposta= true;
			}
		}
		else if(button==2) {
			if((matriz[0][0]==valor&&matriz[2][0]==valor) || (matriz[1][1]==valor&&matriz[1][2]==valor)) {
				resposta= true;
			}
		}
		else if(button==3) {
			if((matriz[0][0]==valor&&matriz[1][0]==valor) || (matriz[2][1]==valor&&matriz[2][2]==valor)||(matriz[1][1]==valor&&matriz[0][2]==valor)) {
				resposta=true;
			}
		}
		else if(button==4) {
			if((matriz[1][1]==valor&&matriz[2][1]==valor) || (matriz[0][0]==valor&&matriz[0][2]==valor)) {
				resposta=true;
			}
		}
		else if(button==5) {
			if((matriz[0][1]==valor&&matriz[2][1]==valor) || (matriz[1][0]==valor&&matriz[1][2]==valor) || (matriz[0][0]==valor&&matriz[2][2]==valor) || (matriz[2][0]==valor&&matriz[0][2]==valor)) {
				resposta=true;
			}
		}
		if(button==6) {
			if((matriz[0][1]==valor&&matriz[1][1]==valor) || (matriz[2][0]==valor&&matriz[2][2]==valor)) {
				resposta=true;
			}
		}
		if(button==7) {
			if((matriz[1][2]==valor&&matriz[2][2]==valor) || (matriz[0][0]==valor&&matriz[0][1]==valor)||(matriz[1][1]==valor&&matriz[2][0]==valor)) {
				resposta=true;
			}
		}
		if(button==8) {
			if((matriz[0][2]==valor&&matriz[2][2]==valor) || (matriz[1][0]==valor&&matriz[1][1]==valor)) {
				resposta=true;
			}
		}
		if(button==9) {
			if((matriz[0][2]==valor&&matriz[1][2]==valor) || (matriz[2][0]==valor&&matriz[2][1]==valor)||(matriz[1][1]==valor&&matriz[0][0]==valor)) {
				resposta=true;
			}
		}
		return resposta;
	}
	public boolean verificaEmpate() {
		contadorJogadas++;
		if(contadorJogadas==9) {
			return true;
		}
		return false;
	}
	public void terminaJogo(boolean empate, JFrame frame, Jogador objJogador) {
		objJogador.computarResultado("visitante", "Derrota");
		frame.dispose();
	}
}
