package jogo;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class tRecebeAcaoServidor implements Runnable{
	JogoDaVelha tela;
	Socket cliente;
	
	public tRecebeAcaoServidor(JogoDaVelha tela, Socket cliente) {
		this.tela=tela;
		this.cliente=cliente;
	}
	
	public void run() {
		String acaoServidor;
		Scanner s;
		try {
			s=new Scanner(cliente.getInputStream());
			while(s.hasNextLine()) {
				acaoServidor=s.nextLine();
				if(acaoServidor.equals("1")) {
					if(tela.flag) {
						tela.matriz[0][0]=0;
						tela.button1.setText("X");
						if(tela.controlador.checkMatriz(tela.matriz,1,0)) {
							if(tela.primeiro) {
								JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
								tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
							}else {
								JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
								tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
							}
						}
						tela.flag=false;
					}
					else {
						tela.matriz[0][0]=1;
						tela.button1.setText("O");
						if(tela.controlador.checkMatriz(tela.matriz,1,1)) {
							if(tela.primeiro) {
								JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
								tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
							}else {
								JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
								tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
							}
						}
						tela.flag=true;
					}
					tela.minhaVez=true;
					
					tela.button1.setEnabled(false);
					if(tela.controlador.verificaEmpate()){
						JOptionPane.showMessageDialog(null, "Deu velha");
						new tEscritaGeral().enviarParaServidor(cliente, "0");
						new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Empate");
						tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Empate");
					}
				}else if(acaoServidor.equals("2")) {
					if(tela.flag) {
					tela.matriz[1][0]=0;
					tela.button2.setText("X");
					if(tela.controlador.checkMatriz(tela.matriz,2,0)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}else {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}
					}
					tela.flag=false;
				}
				else {
					tela.matriz[1][0]=1;
					tela.button2.setText("O");
					if(tela.controlador.checkMatriz(tela.matriz,2,1)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}else {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}
					}
					tela.flag=true;
				}
					tela.button2.setEnabled(false);
				if(tela.controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					new tEscritaGeral().enviarParaServidor(cliente, "0");
					new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Empate");
					tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Empate");
				}
				tela.minhaVez=true;
			}else if(acaoServidor.equals("3")) {
				if(tela.flag) {
					tela.matriz[2][0]=0;
					tela.button3.setText("X");
					if(tela.controlador.checkMatriz(tela.matriz,3,0)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}else {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}
					}
					tela.flag=false;
				}
				else {
					tela.matriz[2][0]=1;
					tela.button3.setText("O");
					if(tela.controlador.checkMatriz(tela.matriz,3,1)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}else {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}
					}
					tela.flag=true;
				}
				tela.button3.setEnabled(false);
				if(tela.controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					new tEscritaGeral().enviarParaServidor(cliente, "0");
					new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Empate");
					tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Empate");
				}
				tela.minhaVez=true;
			}else if(acaoServidor.equals("4")) {
				if(tela.flag) {
					tela.matriz[0][1]=0;
					tela.button4.setText("X");
					if(tela.controlador.checkMatriz(tela.matriz,4,0)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}else {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}
					}
					tela.flag=false;
				}
				else {
					tela.matriz[0][1]=1;
					tela.button4.setText("O");
					if(tela.controlador.checkMatriz(tela.matriz,4,1)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}else {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}
					}
					tela.flag=true;
				}
				tela.button4.setEnabled(false);
				if(tela.controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					new tEscritaGeral().enviarParaServidor(cliente, "0");
					new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Empate");
					tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Empate");
				}
				tela.minhaVez=true;
			}else if(acaoServidor.equals("5")) {
				if(tela.flag) {
					tela.matriz[1][1]=0;
					tela.button5.setText("X");
					if(tela.controlador.checkMatriz(tela.matriz,5,0)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}else {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}
					}
					tela.flag=false;
				}
				else {
					tela.matriz[1][1]=1;
					tela.button5.setText("O");
					if(tela.controlador.checkMatriz(tela.matriz,5,1)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}else {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}
					}
					tela.flag=true;
				}
				tela.button5.setEnabled(false);
				if(tela.controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					new tEscritaGeral().enviarParaServidor(cliente, "0");
					new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Empate");
					tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Empate");
				}
				tela.minhaVez=true;
			}else if(acaoServidor.equals("6")) {
				if(tela.flag) {
					tela.matriz[2][1]=0;
					tela.button6.setText("X");
					if(tela.controlador.checkMatriz(tela.matriz,6,0)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}else {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}
					}
					tela.flag=false;
				}
				else {
					tela.matriz[2][1]=1;
					tela.button6.setText("O");
					if(tela.controlador.checkMatriz(tela.matriz,6,1)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}else {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}
					}
					tela.flag=true;
				}
				tela.button6.setEnabled(false);
				if(tela.controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					new tEscritaGeral().enviarParaServidor(cliente, "0");
					new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Empate");
					tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Empate");
				}
				tela.minhaVez=true;
			}else if(acaoServidor.equals("7")) {
				if(tela.flag) {
					tela.matriz[0][2]=0;
					tela.button7.setText("X");
					if(tela.controlador.checkMatriz(tela.matriz,7,0)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}else {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}
					}
					tela.flag=false;
				}
				else {
					tela.matriz[0][2]=1;
					tela.button7.setText("O");
					if(tela.controlador.checkMatriz(tela.matriz,7,1)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}else {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}
					}
					tela.flag=true;
				}
				tela.button7.setEnabled(false);
				if(tela.controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					new tEscritaGeral().enviarParaServidor(cliente, "0");
					new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Empate");
					tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Empate");
				}
				tela.minhaVez=true;
			}else if(acaoServidor.equals("8")) {
				if(tela.flag) {
					tela.matriz[1][2]=0;
					tela.button8.setText("X");
					if(tela.controlador.checkMatriz(tela.matriz,8,0)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}else {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}
					}
					tela.flag=false;
				}
				else {
					tela.matriz[1][2]=1;
					tela.button8.setText("O");
					if(tela.controlador.checkMatriz(tela.matriz,8,1)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}else {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}
					}
					tela.flag=true;
				}
				tela.button8.setEnabled(false);
				if(tela.controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					new tEscritaGeral().enviarParaServidor(cliente, "0");
					new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Empate");
					tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Empate");
				}
				tela.minhaVez=true;
			}else if(acaoServidor.equals("9")) {
				if(tela.flag) {
					tela.matriz[2][2]=0;
					tela.button9.setText("X");
					if(tela.controlador.checkMatriz(tela.matriz,9,0)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}else {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}
					}
					tela.flag=false;
				}
				else {
					tela.matriz[2][2]=1;
					tela.button9.setText("O");
					if(tela.controlador.checkMatriz(tela.matriz,9,1)) {
						if(tela.primeiro) {
							JOptionPane.showMessageDialog(null, tela.adversario+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Derrota");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Derrota");
						}else {
							JOptionPane.showMessageDialog(null, tela.jogador.getNomeUsuario()+" venceu!");
							new tEscritaGeral().enviarParaServidor(cliente, "0");
							new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Vitoria");
							tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Vitoria");
						}
					}
					tela.flag=true;
				}
				tela.button9.setEnabled(false);
				if(tela.controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					new tEscritaGeral().enviarParaServidor(cliente, "0");
					new tEscritaGeral().enviarParaServidor(cliente, tela.adversario+":Empate");
					tela.controlador.terminaJogo(tela.frame, tela.jogador, tela.adversario, "Empate");
				}
				tela.minhaVez=true;
			}
				
			}
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
