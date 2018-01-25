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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 481);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmNovoJogo = new JMenuItem("Novo Jogo");
		mnInicio.add(mntmNovoJogo);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Sair");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO adicionar açao de fechar a app
	
			}
		});
		mnInicio.add(mntmNewMenuItem);
		
		JMenu mnHistorico = new JMenu("Historico");
		menuBar.add(mnHistorico);
		
		JMenuItem Vitorias = new JMenuItem("Vitorias");
		mnHistorico.add(Vitorias);
		
		JMenuItem Derrotas = new JMenuItem("Derrotas");
		mnHistorico.add(Derrotas);
		
		JMenuItem Empates = new JMenuItem("Empates");
		mnHistorico.add(Empates);
		
		JMenuItem UltimosJogos = new JMenuItem("Utimos 10 jogos");
		UltimosJogos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnHistorico.add(UltimosJogos);
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
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
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
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(201, Short.MAX_VALUE)
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
							.addComponent(textFieldDerrotas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
