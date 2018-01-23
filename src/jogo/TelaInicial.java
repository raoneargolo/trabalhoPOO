package jogo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 375);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mnInicio.add(mntmSalvar);
		
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
		
		JMenu mnNewMenu_2 = new JMenu("New menu");
		menuBar.add(mnNewMenu_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
