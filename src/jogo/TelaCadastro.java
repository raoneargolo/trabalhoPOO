package jogo;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JPanel {
	private JPasswordField campoConfirmarSenha;
	private JPasswordField campoSenha;
	private JTextField campoUsuario;
	private JTextField campoNome;
	static String nome;
	static String usuario;
	static String senha;
	static String confirmarSenha;
	/**
	 * Create the panel.
	 */
	public TelaCadastro(final JFrame frame, Map<String, String>mapaUsuarios, Socket cliente) { //em todo cabeçalho de panel, chama o frame
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_3 = new JLabel("Confirmar senha");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nome = campoNome.getText();
				usuario = campoUsuario.getText();
				senha = String.valueOf(campoSenha.getPassword());
				confirmarSenha = String.valueOf(campoConfirmarSenha.getPassword());
				
				TratamentoDeUsuarios objLerUsuarios = new TratamentoDeUsuarios();
				boolean senhasIguais = objLerUsuarios.SenhaIgualConfirmarSenha(senha, confirmarSenha);
				boolean usuarioNovo = objLerUsuarios.ValidacaoUsuarioCadastro(usuario, mapaUsuarios);
				
				if(usuarioNovo == true && senhasIguais == true) { //Novo usuário disponível e senhas conferem (iguais)
					
					//Validacao.CadastrarUsuario(usuario, senha);
					objLerUsuarios.cadastrarJogador(usuario, confirmarSenha, mapaUsuarios);
					
					JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
					Jogador objJogador = new Jogador(usuario, senha);
					
					String entrada = "cada"+usuario+":"+senha;
					new tEscritaGeral().enviarParaServidor(cliente, entrada);	
					
					setVisible(false); //setar o panel como falso
					TelaInicial ti = new TelaInicial(frame, mapaUsuarios, objJogador); //crio objeto do proximo panel
					frame.setContentPane(ti); //colocar no frame o proximo panel
				}
				
				if(usuarioNovo == true && senhasIguais == false) { //Usuário disponível e senhas não conferem (diferentes)
					
					JOptionPane.showMessageDialog(null, "As senhas não conferem. Favor inserir nova senha");
					
					campoSenha.setText("");
					campoConfirmarSenha.setText("");
				}
				
				if(usuarioNovo == false && senhasIguais == true) { //Usuário indisponível e senhas conferem (iguais)
					
					JOptionPane.showMessageDialog(null, "Já existe um usuário igual! Por favor, escolha outro");
					
					campoUsuario.setText("");
					campoSenha.setText("");
					campoConfirmarSenha.setText("");
				}
				if(usuarioNovo == false && senhasIguais == false) {
					
					JOptionPane.showMessageDialog(null, "Já existe um usuário igual e as senhas não conferem. Por favor, "
							+ "escolha outro usuário e senha");
					campoUsuario.setText("");
					campoSenha.setText("");
					campoConfirmarSenha.setText("");
				}
			}
		});

		campoConfirmarSenha = new JPasswordField();

		campoSenha = new JPasswordField();

		campoUsuario = new JTextField();
		campoUsuario.setColumns(10);

		campoNome = new JTextField();
		campoNome.setColumns(10);

		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 26));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(lblNewLabel_3).addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(campoConfirmarSenha, GroupLayout.PREFERRED_SIZE, 149,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(112)
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblNewLabel).addComponent(lblNewLabel_1))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(campoUsuario, 149, 149, Short.MAX_VALUE)
																.addComponent(campoNome, GroupLayout.DEFAULT_SIZE,
																		149, Short.MAX_VALUE)))
												.addGroup(groupLayout.createSequentialGroup().addGap(199)
														.addComponent(lblCadastro)))
										.addGroup(groupLayout.createSequentialGroup().addGap(123)
												.addComponent(lblNewLabel_2)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(campoSenha, 149, 149, 149))))
						.addGap(175))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(210).addComponent(btnNewButton)
						.addContainerGap(209, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(22)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblCadastro).addGap(84).addComponent(
								campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel))
				.addGap(30)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(campoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
				.addGap(30)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(campoSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
				.addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(campoConfirmarSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
				.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE).addComponent(btnNewButton)
				.addGap(75)));
		setLayout(groupLayout);

	}

}