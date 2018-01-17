package jogo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class JogoDaVelha {
	public boolean flag = true;
	int[][] matriz= {{2,2,2},{2,2,2},{2,2,2},};
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoDaVelha window = new JogoDaVelha();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JogoDaVelha() {
		initialize();
	}
	
	public boolean checkMatriz(int button, int valor) {
		if(button==1) {
			if((matriz[1][0]==valor&&matriz[2][0]==valor) || (matriz[0][1]==valor&&matriz[0][2]==valor) || (matriz[1][1]==valor&&matriz[2][2]==valor)) {
				return true;
			}
		}
		else if(button==2) {
			if((matriz[0][0]==valor&&matriz[2][0]==valor) || (matriz[1][1]==valor&&matriz[1][2]==valor)) {
				return true;
			}
		}
		else if(button==3) {
			if((matriz[0][0]==valor&&matriz[1][0]==valor) || (matriz[2][1]==valor&&matriz[2][2]==valor)||(matriz[1][1]==valor&&matriz[0][2]==valor)) {
				return true;
			}
		}
		else if(button==4) {
			if((matriz[1][1]==valor&&matriz[2][1]==valor) || (matriz[0][0]==valor&&matriz[0][2]==valor)) {
				return true;
			}
		}
		else if(button==5) {
			if((matriz[0][1]==valor&&matriz[2][1]==valor) || (matriz[1][0]==valor&&matriz[1][2]==valor) || (matriz[0][0]==valor&&matriz[2][2]==valor) || (matriz[2][0]==valor&&matriz[0][2]==valor)) {
				return true;
			}
		}
		if(button==6) {
			if((matriz[0][1]==valor&&matriz[1][1]==valor) || (matriz[2][0]==valor&&matriz[2][2]==valor)) {
				return true;
			}
		}
		if(button==7) {
			if((matriz[1][2]==valor&&matriz[2][2]==valor) || (matriz[0][0]==valor&&matriz[0][1]==valor)||(matriz[1][1]==valor&&matriz[2][0]==valor)) {
				return true;
			}
		}
		if(button==8) {
			if((matriz[0][2]==valor&&matriz[2][2]==valor) || (matriz[1][0]==valor&&matriz[1][1]==valor)) {
				return true;
			}
		}
		if(button==9) {
			if((matriz[0][2]==valor&&matriz[1][2]==valor) || (matriz[2][0]==valor&&matriz[2][1]==valor)||(matriz[1][1]==valor&&matriz[0][0]==valor)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button1 = new JButton("");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[0][0]=0;
					button1.setBackground(Color.RED);
					if(checkMatriz(1,0)) {
						JOptionPane.showMessageDialog(null, "Vermelho Venceu!");
					}
					flag=false;
				}
				else {
					matriz[0][0]=1;
					button1.setBackground(Color.BLUE);
					if(checkMatriz(1,1)) {
						JOptionPane.showMessageDialog(null, "Azul Venceu!");
					}
					flag=true;
				}
				button1.setEnabled(false);
			}
		});
		button1.setBounds(0, 0, 146, 87);
		frame.getContentPane().add(button1);
		
		
		JButton button2 = new JButton("");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[1][0]=0;
					button2.setBackground(Color.RED);
					if(checkMatriz(2,0)) {
						JOptionPane.showMessageDialog(null, "Vermelho Venceu!");
					}
					flag=false;
				}
				else {
					matriz[1][0]=1;
					button2.setBackground(Color.BLUE);
					if(checkMatriz(2,1)) {
						JOptionPane.showMessageDialog(null, "Azul Venceu!");
					}
					flag=true;
				}
				button2.setEnabled(false);
			}
		});
		button2.setBounds(0, 86, 146, 87);
		frame.getContentPane().add(button2);
		
		JButton button3 = new JButton("");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[2][0]=0;
					button3.setBackground(Color.RED);
					if(checkMatriz(3,0)) {
						JOptionPane.showMessageDialog(null, "Vermelho Venceu!");
					}
					flag=false;
				}
				else {
					matriz[2][0]=1;
					button3.setBackground(Color.BLUE);
					if(checkMatriz(3,1)) {
						JOptionPane.showMessageDialog(null, "Azul Venceu!");
					}
					flag=true;
				}
				button3.setEnabled(false);
			}
		});
		button3.setBounds(0, 174, 146, 87);
		frame.getContentPane().add(button3);
		
		JButton button4 = new JButton("");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[0][1]=0;
					button4.setBackground(Color.RED);
					if(checkMatriz(4,0)) {
						JOptionPane.showMessageDialog(null, "Vermelho Venceu!");
					}
					flag=false;
				}
				else {
					matriz[0][1]=1;
					button4.setBackground(Color.BLUE);
					if(checkMatriz(4,1)) {
						JOptionPane.showMessageDialog(null, "Azul Venceu!");
					}
					flag=true;
				}
				button4.setEnabled(false);
			}
		});
		button4.setBounds(145, 0, 146, 87);
		frame.getContentPane().add(button4);
		
		JButton button5 = new JButton("");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[1][1]=0;
					button5.setBackground(Color.RED);
					if(checkMatriz(5,0)) {
						JOptionPane.showMessageDialog(null, "Vermelho Venceu!");
					}
					flag=false;
				}
				else {
					matriz[1][1]=1;
					button5.setBackground(Color.BLUE);
					if(checkMatriz(5,1)) {
						JOptionPane.showMessageDialog(null, "Azul Venceu!");
					}
					flag=true;
				}
				button5.setEnabled(false);
			}
		});
		button5.setBounds(145, 86, 146, 87);
		frame.getContentPane().add(button5);
		
		JButton button6 = new JButton("");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[2][1]=0;
					button6.setBackground(Color.RED);
					if(checkMatriz(6,0)) {
						JOptionPane.showMessageDialog(null, "Vermelho Venceu!");
					}
					flag=false;
				}
				else {
					matriz[2][1]=1;
					button6.setBackground(Color.BLUE);
					if(checkMatriz(6,1)) {
						JOptionPane.showMessageDialog(null, "Azul Venceu!");
					}
					flag=true;
				}
				button6.setEnabled(false);
			}
		});
		button6.setBounds(145, 174, 146, 87);
		frame.getContentPane().add(button6);
		
		JButton button7 = new JButton("");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[0][2]=0;
					button7.setBackground(Color.RED);
					if(checkMatriz(7,0)) {
						JOptionPane.showMessageDialog(null, "Vermelho Venceu!");
					}
					flag=false;
				}
				else {
					matriz[0][2]=1;
					button7.setBackground(Color.BLUE);
					if(checkMatriz(7,1)) {
						JOptionPane.showMessageDialog(null, "Azul Venceu!");
					}
					flag=true;
				}
				button7.setEnabled(false);
			}
		});
		button7.setBounds(288, 0, 146, 87);
		frame.getContentPane().add(button7);
		
		JButton button8 = new JButton("");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[1][2]=0;
					button8.setBackground(Color.RED);
					if(checkMatriz(8,0)) {
						JOptionPane.showMessageDialog(null, "Vermelho Venceu!");
					}
					flag=false;
				}
				else {
					matriz[1][2]=1;
					button8.setBackground(Color.BLUE);
					if(checkMatriz(8,1)) {
						JOptionPane.showMessageDialog(null, "Azul Venceu!");
					}
					flag=true;
				}
				button8.setEnabled(false);
			}
		});
		button8.setBounds(288, 86, 146, 87);
		frame.getContentPane().add(button8);
		
		JButton button9 = new JButton("");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					matriz[2][2]=0;
					button9.setBackground(Color.RED);
					if(checkMatriz(9,0)) {
						JOptionPane.showMessageDialog(null, "Vermelho Venceu!");
					}
					flag=false;
				}
				else {
					matriz[2][2]=1;
					button9.setBackground(Color.BLUE);
					if(checkMatriz(9,1)) {
						JOptionPane.showMessageDialog(null, "Azul Venceu!");
					}
					flag=true;
				}
				button9.setEnabled(false);
			}
		});
		button9.setBounds(288, 174, 146, 87);
		frame.getContentPane().add(button9);
	}
}