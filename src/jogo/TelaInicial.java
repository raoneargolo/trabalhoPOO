package jogo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDerrotas;
	private JTextField textFieldEmpates;
	private JTextField textFieldVitorias;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 481);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmNovoJogo = new JMenuItem("Novo Jogo");
		mnInicio.add(mntmNovoJogo);
		
		mntmNovoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teste T1 = new teste(); // chamando a jenela do jogo
				T1.setVisible(true);
			}
		});
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Sair");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO adicionar açao de fechar a app
				
				System.exit(0); // Comando para fechar a janela atual
	
			}
		});
		mnInicio.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textFieldDerrotas = new JTextField();
		textFieldDerrotas.setColumns(10);
		
		textFieldEmpates = new JTextField();
		textFieldEmpates.setColumns(10);
		
		textFieldVitorias = new JTextField();
		textFieldVitorias.setColumns(10);
		
		JLabel lblDerrotas = new JLabel("Derrotas");
		
		JLabel lblEmpates = new JLabel("Empates");
		
		JLabel lblVitorias = new JLabel("Vitorias");
		
		table = new JTable(11,3);
		
		String[] columnNames = {"Vitoria","Derrota","Empate"};
		Object[][] data = {
			    {"Vitoria","Derrota","Empate"},
			    {"John", "Doe","Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black","Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White","Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown","Pool", new Integer(10), new Boolean(false)}
			};
		
		JTable table = new JTable(data, columnNames);
		
		JLabel lblUltimosJogos = new JLabel("Ultimos 10 Jogos");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
							.addGap(79)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldVitorias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblVitorias)
									.addGap(32))
								.addComponent(textFieldDerrotas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldEmpates, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDerrotas)
									.addGap(31))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEmpates)
									.addGap(28))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(168)
							.addComponent(lblUltimosJogos)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblUltimosJogos)
					.addGap(4)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
					.addGap(23))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(114, Short.MAX_VALUE)
					.addComponent(lblVitorias)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldVitorias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblEmpates)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldEmpates, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(lblDerrotas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldDerrotas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(110))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
