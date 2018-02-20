package jogo;

import java.awt.EventQueue;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("unused")
public class JogoDaVelha{
	ControlaJogo controlador = new ControlaJogo();
	Random rand = new Random();
	int defineX = rand.nextInt(2);
	public boolean flag=true,whoseTurn;
	int[][] matriz= {{2,2,2},{2,2,2},{2,2,2},};
	public JFrame frame;
	public Jogador jogador;
	public String adversario;
	public boolean minhaVez=false;
	public boolean primeiro=false;
	public Socket cliente;
//	botoes
	public JButton button1;
	public JButton button2;
	public JButton button3;
	public JButton button4;
	public JButton button5;
	public JButton button6;
	public JButton button7;
	public JButton button8;
	public JButton button9;
	
	
	public JogoDaVelha(Socket cliente, String minhaPosicao, Jogador jogador, String adversario) {
		if(minhaPosicao.equals("j1")) {			
			minhaVez=true;
			primeiro=true;
		}
		this.jogador=jogador;
		this.adversario=adversario;
		
		this.cliente=cliente;
		
		if(defineX==0) {
			whoseTurn=true;
		}
		else {
			whoseTurn=false;
		}
		//initialize();
	}
	
//	public void Receberjogadores(Jogador jogador1, Jogador jogador2) {
//		this.jogador1=jogador1;
//		this.jogador2=jogador2;
//	}
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoDaVelha window = new JogoDaVelha("Eduardo","Eric");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application.
	 */
	//public JogoDaVelha() {
		//initialize();
	//}
	
	
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @wbp.parser.entryPoint
	 */
	public void initialize() throws IOException {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 677, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		button1 = new JButton("");
		button1.setFont(new Font("Tahoma", Font.BOLD, 70));
		button1.setToolTipText("");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(minhaVez) {
					
					new tEscritaGeral().enviarParaServidor(cliente, "1");
					
					if(flag) {
						matriz[0][0]=0;
						button1.setText("X");
						if(controlador.checkMatriz(matriz,1,0)) {
							//JOptionPane.showMessageDialog(null, "X venceu!");
							if(primeiro) {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}else {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}
						}
						flag=false;
					}
					else {
						matriz[0][0]=1;
						button1.setText("O");
						if(controlador.checkMatriz(matriz,1,1)) {
							//JOptionPane.showMessageDialog(null, "O venceu!");
							if(primeiro) {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}else {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}
						}
						flag=true;
					}
					minhaVez=false;
					
					button1.setEnabled(false);
					if(controlador.verificaEmpate()){
						JOptionPane.showMessageDialog(null, "Deu velha");
						new tEscritaGeral().enviarParaServidor(cliente, "0");
						new tEscritaGeral().enviarParaServidor(cliente, adversario+":Empate");
						controlador.terminaJogo(frame, jogador, adversario, "Empate");
					}
				}
				
			}
		});
		button1.setBounds(0, 0, 146, 87);
		frame.getContentPane().add(button1);
		
		
		button2 = new JButton("");
		button2.setFont(new Font("Tahoma", Font.BOLD, 70));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(minhaVez) {
					
					new tEscritaGeral().enviarParaServidor(cliente, "2");
					
					if(flag) {
						matriz[1][0]=0;
						button2.setText("X");
						if(controlador.checkMatriz(matriz,2,0)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}else {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}
						}
						flag=false;
					}
					else {
						matriz[1][0]=1;
						button2.setText("O");
						if(controlador.checkMatriz(matriz,2,1)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}else {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}
						}
						flag=true;
					}
					button2.setEnabled(false);
					if(controlador.verificaEmpate()){
						JOptionPane.showMessageDialog(null, "Deu velha");
						new tEscritaGeral().enviarParaServidor(cliente, "0");
						new tEscritaGeral().enviarParaServidor(cliente, adversario+":Empate");
						controlador.terminaJogo(frame, jogador, adversario, "Empate");
					}
					minhaVez=false;
				}
				
			}
		});
		button2.setBounds(0, 86, 146, 87);
		frame.getContentPane().add(button2);
		
		button3 = new JButton("");
		button3.setFont(new Font("Tahoma", Font.BOLD, 70));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(minhaVez) {
					
					new tEscritaGeral().enviarParaServidor(cliente, "3");
					
					if(flag) {
						matriz[2][0]=0;
						button3.setText("X");
						if(controlador.checkMatriz(matriz,3,0)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}else {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}
						}
						flag=false;
					}
					else {
						matriz[2][0]=1;
						button3.setText("O");
						if(controlador.checkMatriz(matriz,3,1)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}else {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}
						}
						flag=true;
					}
					button3.setEnabled(false);
					if(controlador.verificaEmpate()){
						JOptionPane.showMessageDialog(null, "Deu velha");
						new tEscritaGeral().enviarParaServidor(cliente, "0");
						new tEscritaGeral().enviarParaServidor(cliente, adversario+":Empate");
						controlador.terminaJogo(frame, jogador, adversario, "Empate");
					}
					minhaVez=false;
				}
			}
		});
		button3.setBounds(0, 174, 146, 87);
		frame.getContentPane().add(button3);
		
		button4 = new JButton("");
		button4.setFont(new Font("Tahoma", Font.BOLD, 70));
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(minhaVez) {
					
					new tEscritaGeral().enviarParaServidor(cliente, "4");
					
					if(flag) {
						matriz[0][1]=0;
						button4.setText("X");
						if(controlador.checkMatriz(matriz,4,0)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}else {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}
						}
						flag=false;
					}
					else {
						matriz[0][1]=1;
						button4.setText("O");
						if(controlador.checkMatriz(matriz,4,1)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}else {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}
						}
						flag=true;
					}
					button4.setEnabled(false);
					if(controlador.verificaEmpate()){
						JOptionPane.showMessageDialog(null, "Deu velha");
						new tEscritaGeral().enviarParaServidor(cliente, "0");
						new tEscritaGeral().enviarParaServidor(cliente, adversario+":Empate");
						controlador.terminaJogo(frame, jogador, adversario, "Empate");
					}
					minhaVez=false;
				}
				
			}
		});
		button4.setBounds(145, 0, 146, 87);
		frame.getContentPane().add(button4);
		
		button5 = new JButton("");
		button5.setFont(new Font("Tahoma", Font.BOLD, 70));
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(minhaVez) {
					
					new tEscritaGeral().enviarParaServidor(cliente, "5");
					
					if(flag) {
						matriz[1][1]=0;
						button5.setText("X");
						if(controlador.checkMatriz(matriz,5,0)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}else {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}
						}
						flag=false;
					}
					else {
						matriz[1][1]=1;
						button5.setText("O");
						if(controlador.checkMatriz(matriz,5,1)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}else {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}
						}
						flag=true;
					}
					button5.setEnabled(false);
					if(controlador.verificaEmpate()){
						JOptionPane.showMessageDialog(null, "Deu velha");
						new tEscritaGeral().enviarParaServidor(cliente, "0");
						new tEscritaGeral().enviarParaServidor(cliente, adversario+":Empate");
						controlador.terminaJogo(frame, jogador, adversario, "Empate");
					}
					minhaVez=false;
				}
				
			}
		});
		button5.setBounds(145, 86, 146, 87);
		frame.getContentPane().add(button5);
		
		button6 = new JButton("");
		button6.setFont(new Font("Tahoma", Font.BOLD, 70));
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(minhaVez) {
					
					new tEscritaGeral().enviarParaServidor(cliente, "6");
					
					if(flag) {
						matriz[2][1]=0;
						button6.setText("X");
						if(controlador.checkMatriz(matriz,6,0)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}else {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}
						}
						flag=false;
					}
					else {
						matriz[2][1]=1;
						button6.setText("O");
						if(controlador.checkMatriz(matriz,6,1)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}else {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}
						}
						flag=true;
					}
					button6.setEnabled(false);
					if(controlador.verificaEmpate()){
						JOptionPane.showMessageDialog(null, "Deu velha");
						new tEscritaGeral().enviarParaServidor(cliente, "0");
						new tEscritaGeral().enviarParaServidor(cliente, adversario+":Empate");
						controlador.terminaJogo(frame, jogador, adversario, "Empate");
					}
					minhaVez=false;
				}
				
			}
		});
		button6.setBounds(145, 174, 146, 87);
		frame.getContentPane().add(button6);
		
		button7 = new JButton("");
		button7.setFont(new Font("Tahoma", Font.BOLD, 70));
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(minhaVez) {
					
					new tEscritaGeral().enviarParaServidor(cliente, "7");
					
					if(flag) {
						matriz[0][2]=0;
						button7.setText("X");
						if(controlador.checkMatriz(matriz,7,0)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}else {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}
						}
						flag=false;
					}
					else {
						matriz[0][2]=1;
						button7.setText("O");
						if(controlador.checkMatriz(matriz,7,1)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}else {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}
						}
						flag=true;
					}
					button7.setEnabled(false);
					if(controlador.verificaEmpate()){
						JOptionPane.showMessageDialog(null, "Deu velha");
						new tEscritaGeral().enviarParaServidor(cliente, "0");
						new tEscritaGeral().enviarParaServidor(cliente, adversario+":Empate");
						controlador.terminaJogo(frame, jogador, adversario, "Empate");
					}
					minhaVez=false;
				}
				
			}
		});
		button7.setBounds(290, 0, 146, 87);
		frame.getContentPane().add(button7);
		
		button8 = new JButton("");
		button8.setFont(new Font("Tahoma", Font.BOLD, 70));
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(minhaVez) {
					
					new tEscritaGeral().enviarParaServidor(cliente, "8");
					
					if(flag) {
						matriz[1][2]=0;
						button8.setText("X");
						if(controlador.checkMatriz(matriz,8,0)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}else {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}
						}
						flag=false;
					}
					else {
						matriz[1][2]=1;
						button8.setText("O");
						if(controlador.checkMatriz(matriz,8,1)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}else {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}
						}
						flag=true;
					}
					button8.setEnabled(false);
					if(controlador.verificaEmpate()){
						JOptionPane.showMessageDialog(null, "Deu velha");
						new tEscritaGeral().enviarParaServidor(cliente, "0");
						new tEscritaGeral().enviarParaServidor(cliente, adversario+":Empate");
						controlador.terminaJogo(frame, jogador, adversario, "Empate");
					}
					minhaVez=false;
				}
				
			}
		});
		button8.setBounds(290, 86, 146, 87);
		frame.getContentPane().add(button8);
		
		button9 = new JButton("");
		button9.setFont(new Font("Tahoma", Font.BOLD, 70));
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(minhaVez) {
					
					new tEscritaGeral().enviarParaServidor(cliente, "9");
					
					if(flag) {
						matriz[2][2]=0;
						button9.setText("X");
						if(controlador.checkMatriz(matriz,9,0)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}else {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}
						}
						flag=false;
					}
					else {
						matriz[2][2]=1;
						button9.setText("O");
						if(controlador.checkMatriz(matriz,9,1)) {
							if(primeiro) {
								JOptionPane.showMessageDialog(null, adversario+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Derrota");
								controlador.terminaJogo(frame, jogador, adversario, "Derrota");
							}else {
								JOptionPane.showMessageDialog(null, jogador.getNomeUsuario()+" venceu!");
								new tEscritaGeral().enviarParaServidor(cliente, "0");
								new tEscritaGeral().enviarParaServidor(cliente, adversario+":Vitoria");
								controlador.terminaJogo(frame, jogador, adversario, "Vitoria");
							}
						}
						flag=true;
					}
					button9.setEnabled(false);
					if(controlador.verificaEmpate()){
						JOptionPane.showMessageDialog(null, "Deu velha");
						new tEscritaGeral().enviarParaServidor(cliente, "0");
						new tEscritaGeral().enviarParaServidor(cliente, adversario+":Empate");
						controlador.terminaJogo(frame, jogador, adversario, "Empate");
					}
					minhaVez=false;
				}
				
			}
		});
		button9.setBounds(290, 174, 146, 87);
		frame.getContentPane().add(button9);		
		
		JLabel lblNewLabel = new JLabel("Jogador 1");
		lblNewLabel.setBounds(530, 13, 71, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jogador 2");
		lblNewLabel_1.setBounds(530, 110, 71, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setBounds(530, 40, 71, 14);
		frame.getContentPane().add(label);		
		if(primeiro) {
			label.setText(jogador.getNomeUsuario());
		}else {
			label.setText(adversario);
		}	
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(530, 154, 71, 14);
		frame.getContentPane().add(label_1);
		if(primeiro) {
			label_1.setText(adversario);
		}else {
			label_1.setText(jogador.getNomeUsuario());
		}
				
	}
}