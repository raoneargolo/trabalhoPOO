package jogo;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class TelaLogon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField campoSenha;
	private JTextField campoUsuario;
	private static TelaLogon frame;
	static String usuario;
	static String senha;
	static Map<String, String> mapaUsuarios = new HashMap<String, String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LerUsuario objLerUsuario = new LerUsuario();
		mapaUsuarios = objLerUsuario.lerUsuarios();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				frame = new TelaLogon();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnIncio = new JMenu("In\u00EDcio");
		menuBar.add(mnIncio);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mnIncio.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));

		campoSenha = new JPasswordField();
		
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 16));

		campoUsuario = new JTextField();
		campoUsuario.setColumns(10);
		
		JButton btnEntrarComoConvidade = new JButton("Entrar como convidado");
		btnEntrarComoConvidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TratamentoDeUsuarios obj = new TratamentoDeUsuarios();
				usuario = obj.gerarVisitante(mapaUsuarios);
				Jogador objJogador = new Jogador(usuario, usuario);
				TelaInicial ti = new TelaInicial(frame, mapaUsuarios, objJogador);
				contentPane.setVisible(false);
				ti.setVisible(true);
				setContentPane(ti);
				ti.setRequestFocusEnabled(true);
			}
		});

		JButton btnNovoJogador = new JButton("Novo jogador");
		btnNovoJogador.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro tc = new TelaCadastro(frame, mapaUsuarios); // instancia panel
				contentPane.setVisible(false); // deixa conteudo do panel atual desabilitado
				tc.setVisible(true); // deixa panel que eu quero habilitado
				setContentPane(tc); // insiro no panel do frame o panel que eu quero
				tc.setRequestFocusEnabled(true); // foca no panel que eu quero
			}
		});

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				usuario = campoUsuario.getText();
				senha = String.valueOf(campoSenha.getPassword());
				//senha = campoSenha.getPassword();
				
				int validacao;
				TratamentoDeUsuarios obj = new TratamentoDeUsuarios();
				//boolean validacao = true;
				
				validacao=obj.verificarLogin(usuario, senha, mapaUsuarios);
				
				if(validacao == 1) {
					Jogador objJogador = new Jogador(usuario, senha);
					TelaInicial ti = new TelaInicial(frame, mapaUsuarios, objJogador);
					contentPane.setVisible(false);
					ti.setVisible(true);
					setContentPane(ti);
					ti.setRequestFocusEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usu�rio ou senha incorretos! Por favor tente novamente");
					campoUsuario.setText("");
					campoSenha.setText("");
					usuario=null;					
				}
			}
		});

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap(93, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblSenha).addComponent(lblUsurio))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(campoUsuario, GroupLayout.PREFERRED_SIZE, 154,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(campoSenha, 154, 154, 154))
										.addGap(155))
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addComponent(lblLogo).addGap(189)))
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addComponent(btnEntrar).addGap(200)))
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addComponent(btnEntrarComoConvidade)
										.addContainerGap()))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(btnNovoJogador).addContainerGap()))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblLogo)
						.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(campoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsurio))
						.addGap(30)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(campoSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSenha))
						.addGap(51).addComponent(btnEntrar).addGap(67).addComponent(btnNovoJogador)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnEntrarComoConvidade).addGap(7)));
		contentPane.setLayout(gl_contentPane);
	}
}