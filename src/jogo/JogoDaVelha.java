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
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("unused")
public class JogoDaVelha {
	ControlaJogo controlador = new ControlaJogo();
	Random rand = new Random();
	int defineX = rand.nextInt(2);
	public boolean flag=true,whoseTurn;
	int[][] matriz= {{2,2,2},{2,2,2},{2,2,2},};
	private JFrame frame;
	private Jogador jogador1;
	private Jogador jogador2;
	
	public JogoDaVelha(/*Jogador jogador1*/) {
		//this.jogador1=jogador1;
		//this.jogador2=jogador2;
		if(defineX==0) {
			whoseTurn=true;
		}
		else {
			whoseTurn=false;
		}
		//initialize();
	}
	
	public void Receberjogadores(Jogador jogador1, Jogador jogador2) {
		this.jogador1=jogador1;
		this.jogador2=jogador2;
	}
	
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
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 677, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button1 = new JButton("");
		button1.setFont(new Font("Tahoma", Font.BOLD, 70));
		button1.setToolTipText("");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[0][0]=0;
					button1.setText("X");
					if(controlador.checkMatriz(matriz,1,0)) {
						JOptionPane.showMessageDialog(null, "X venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=false;
				}
				else {
					matriz[0][0]=1;
					button1.setText("O");
					if(controlador.checkMatriz(matriz,1,1)) {
						JOptionPane.showMessageDialog(null, "O venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=true;
				}
				button1.setEnabled(false);
				if(controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					controlador.terminaJogo(true,frame, jogador1);
				}
			}
		});
		button1.setBounds(0, 0, 146, 87);
		frame.getContentPane().add(button1);
		
		
		JButton button2 = new JButton("");
		button2.setFont(new Font("Tahoma", Font.BOLD, 70));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[1][0]=0;
					button2.setText("X");
					if(controlador.checkMatriz(matriz,2,0)) {
						JOptionPane.showMessageDialog(null, "X venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=false;
				}
				else {
					matriz[1][0]=1;
					button2.setText("O");
					if(controlador.checkMatriz(matriz,2,1)) {
						JOptionPane.showMessageDialog(null, "O venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=true;
				}
				button2.setEnabled(false);
				if(controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					controlador.terminaJogo(true,frame, jogador1);
				}
			}
		});
		button2.setBounds(0, 86, 146, 87);
		frame.getContentPane().add(button2);
		
		JButton button3 = new JButton("");
		button3.setFont(new Font("Tahoma", Font.BOLD, 70));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[2][0]=0;
					button3.setText("X");
					if(controlador.checkMatriz(matriz,3,0)) {
						JOptionPane.showMessageDialog(null, "X venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=false;
				}
				else {
					matriz[2][0]=1;
					button3.setText("O");
					if(controlador.checkMatriz(matriz,3,1)) {
						JOptionPane.showMessageDialog(null, "O venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=true;
				}
				button3.setEnabled(false);
				if(controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					controlador.terminaJogo(true,frame, jogador1);
				}
			}
		});
		button3.setBounds(0, 174, 146, 87);
		frame.getContentPane().add(button3);
		
		JButton button4 = new JButton("");
		button4.setFont(new Font("Tahoma", Font.BOLD, 70));
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[0][1]=0;
					button4.setText("X");
					if(controlador.checkMatriz(matriz,4,0)) {
						JOptionPane.showMessageDialog(null, "X venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=false;
				}
				else {
					matriz[0][1]=1;
					button4.setText("O");
					if(controlador.checkMatriz(matriz,4,1)) {
						JOptionPane.showMessageDialog(null, "O venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=true;
				}
				button4.setEnabled(false);
				if(controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					controlador.terminaJogo(true,frame, jogador1);
				}
			}
		});
		button4.setBounds(145, 0, 146, 87);
		frame.getContentPane().add(button4);
		
		JButton button5 = new JButton("");
		button5.setFont(new Font("Tahoma", Font.BOLD, 70));
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[1][1]=0;
					button5.setText("X");
					if(controlador.checkMatriz(matriz,5,0)) {
						JOptionPane.showMessageDialog(null, "X venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=false;
				}
				else {
					matriz[1][1]=1;
					button5.setText("O");
					if(controlador.checkMatriz(matriz,5,1)) {
						JOptionPane.showMessageDialog(null, "O venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=true;
				}
				button5.setEnabled(false);
				if(controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					controlador.terminaJogo(true,frame, jogador1);
				}
			}
		});
		button5.setBounds(145, 86, 146, 87);
		frame.getContentPane().add(button5);
		
		JButton button6 = new JButton("");
		button6.setFont(new Font("Tahoma", Font.BOLD, 70));
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[2][1]=0;
					button6.setText("X");
					if(controlador.checkMatriz(matriz,6,0)) {
						JOptionPane.showMessageDialog(null, "X venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=false;
				}
				else {
					matriz[2][1]=1;
					button6.setText("O");
					if(controlador.checkMatriz(matriz,6,1)) {
						JOptionPane.showMessageDialog(null, "O venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=true;
				}
				button6.setEnabled(false);
				if(controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					controlador.terminaJogo(true,frame, jogador1);
				}
			}
		});
		button6.setBounds(145, 174, 146, 87);
		frame.getContentPane().add(button6);
		
		JButton button7 = new JButton("");
		button7.setFont(new Font("Tahoma", Font.BOLD, 70));
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[0][2]=0;
					button7.setText("X");
					if(controlador.checkMatriz(matriz,7,0)) {
						JOptionPane.showMessageDialog(null, "X venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=false;
				}
				else {
					matriz[0][2]=1;
					button7.setText("O");
					if(controlador.checkMatriz(matriz,7,1)) {
						JOptionPane.showMessageDialog(null, "O venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=true;
				}
				button7.setEnabled(false);
				if(controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					controlador.terminaJogo(true,frame, jogador1);
				}
			}
		});
		button7.setBounds(290, 0, 146, 87);
		frame.getContentPane().add(button7);
		
		JButton button8 = new JButton("");
		button8.setFont(new Font("Tahoma", Font.BOLD, 70));
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[1][2]=0;
					button8.setText("X");
					if(controlador.checkMatriz(matriz,8,0)) {
						JOptionPane.showMessageDialog(null, "X venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=false;
				}
				else {
					matriz[1][2]=1;
					button8.setText("O");
					if(controlador.checkMatriz(matriz,8,1)) {
						JOptionPane.showMessageDialog(null, "O venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=true;
				}
				button8.setEnabled(false);
				if(controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					controlador.terminaJogo(true,frame, jogador1);
				}
			}
		});
		button8.setBounds(290, 86, 146, 87);
		frame.getContentPane().add(button8);
		
		JButton button9 = new JButton("");
		button9.setFont(new Font("Tahoma", Font.BOLD, 70));
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[2][2]=0;
					button9.setText("X");
					if(controlador.checkMatriz(matriz,9,0)) {
						JOptionPane.showMessageDialog(null, "X venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=false;
				}
				else {
					matriz[2][2]=1;
					button9.setText("O");
					if(controlador.checkMatriz(matriz,9,1)) {
						JOptionPane.showMessageDialog(null, "O venceu!");
						controlador.terminaJogo(false,frame, jogador1);
					}
					flag=true;
				}
				button9.setEnabled(false);
				if(controlador.verificaEmpate()){
					JOptionPane.showMessageDialog(null, "Deu velha");
					controlador.terminaJogo(true,frame, jogador1);
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
		label.setText(jogador1.getNomeUsuario());
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(530, 154, 71, 14);
		frame.getContentPane().add(label_1);
		label_1.setText(jogador2.getNomeUsuario());
	}
}
