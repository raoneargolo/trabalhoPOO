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
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaLogon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JPanel contentPane;
	private JPasswordField campoSenha;
	private JTextField campoUsuario;
	//private static TelaLogon frame;
	static String usuario;
	static String senha;
	static Map<String, String> mapaUsuarios = new HashMap<String, String>();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		LerUsuario objLerUsuario = new LerUsuario();
		mapaUsuarios = objLerUsuario.lerUsuarios();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				frame = new TelaLogon(mapaUsuarios, null);
				frame.setVisible(true);
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public TelaLogon(Map<String, String> mapaU, ObjectOutputStream outToServer) {
		setResizable(false);
		mapaUsuarios=mapaU;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600	, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnIncio = new JMenu("In\u00EDcio");
		menuBar.add(mnIncio);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
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
				TelaInicial ti = new TelaInicial(Cliente.frame, mapaUsuarios,objJogador);
//				TelaInicial ti = new TelaInicial(mapaUsuarios,objJogador);
				contentPane.setVisible(false);
				ti.setVisible(true);
				setContentPane(ti);
				ti.setRequestFocusEnabled(true);
			}
		});

		JButton btnNovoJogador = new JButton("Novo jogador");
		btnNovoJogador.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro tc = new TelaCadastro(Cliente.frame, mapaUsuarios, outToServer); // instancia panel
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
					TelaInicial ti = new TelaInicial(Cliente.frame, mapaUsuarios, objJogador);
//					TelaInicial ti = new TelaInicial(mapaUsuarios, objJogador);
					contentPane.setVisible(false);
					ti.setVisible(true);
					setContentPane(ti);
					ti.setRequestFocusEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos! Por favor tente novamente");
					campoUsuario.setText("");
					campoSenha.setText("");
					usuario=null;					
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("INSERIR IMAGEM");
		//lblNewLabel.setIcon(new ImageIcon("F:\\eclise-workspace\\Trabalho de POO\\imagem\\Jogo da velha.jpg"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(259)
					.addComponent(btnEntrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(362))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(149)
							.addComponent(lblSenha)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblUsurio)
							.addGap(21)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(campoUsuario)
						.addComponent(campoSenha, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
					.addGap(164))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addComponent(lblNewLabel)
					.addContainerGap(173, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(396, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEntrarComoConvidade)
						.addComponent(btnNovoJogador))
					.addGap(145))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 264, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addComponent(lblUsurio)
							.addGap(13))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(campoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(campoSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
					.addGap(34)
					.addComponent(btnNovoJogador, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEntrarComoConvidade)
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
	}
}