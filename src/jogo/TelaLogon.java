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
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
	public TelaLogon(Map<String, String> mapaU, Socket cliente) {
	//public TelaLogon(Map<String, String> mapaU, ObjectOutputStream outToServer) {
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
		lblSenha.setBounds(154, 240, 43, 20);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));

		campoSenha = new JPasswordField();
		campoSenha.setBounds(209, 240, 175, 20);
		
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(143, 190, 54, 20);
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 16));

		campoUsuario = new JTextField();
		campoUsuario.setBounds(209, 190, 175, 20);
		campoUsuario.setColumns(10);
		
		JButton btnEntrarComoConvidade = new JButton("Entrar como convidado");
		btnEntrarComoConvidade.setBounds(398, 504, 175, 23);
		btnEntrarComoConvidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TratamentoDeUsuarios obj = new TratamentoDeUsuarios();
				usuario = obj.gerarVisitante(mapaUsuarios);
				Jogador objJogador = new Jogador(usuario, usuario);
				TelaInicial ti = new TelaInicial(Cliente.frame, mapaUsuarios,objJogador, cliente);
//				TelaInicial ti = new TelaInicial(mapaUsuarios,objJogador);
				contentPane.setVisible(false);
				ti.setVisible(true);
				setContentPane(ti);
				ti.setRequestFocusEnabled(true);
			}
		});

		JButton btnNovoJogador = new JButton("Novo jogador");
		btnNovoJogador.setBounds(416, 468, 143, 25);
		btnNovoJogador.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				//TelaCadastro tc = new TelaCadastro(Cliente.frame, mapaUsuarios, outToServer); // instancia panel
				TelaCadastro tc = new TelaCadastro(Cliente.frame, mapaUsuarios, cliente); // instancia panel
				contentPane.setVisible(false); // deixa conteudo do panel atual desabilitado
				tc.setVisible(true); // deixa panel que eu quero habilitado
				setContentPane(tc); // insiro no panel do frame o panel que eu quero
				tc.setRequestFocusEnabled(true); // foca no panel que eu quero
			}
		});

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(248, 304, 97, 25);
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
		        	File file = new File("Numeros2"+usuario);
		        	if(file.exists()) {
		        		file.delete();
		        	}
		        	file = new File("Historico2"+usuario);
		        	if(file.exists()) {
		        		file.delete();
		        	}
					new tEscritaGeral().enviarParaServidor(cliente, "arqu"+usuario);
					
					InputStream inFromServer = null;
			        OutputStream out = null;
			        byte[] bytes;
			        int count;
			        
			        try {
			            inFromServer =cliente.getInputStream();
			        } catch (IOException ex) {
			            System.out.println("Can't get socket input stream. ");
			        }

			        try {
			            out = new FileOutputStream("Numeros2"+usuario);
			            
			        } catch (FileNotFoundException ex) {
			            System.out.println("File not found. ");
			        }

			        bytes = new byte[16*1024];
			        
			        try {
						while ((count = inFromServer.read(bytes)) > 0) {
						    out.write(bytes, 0, count);
						    System.out.println("to aqui");
						    break;
						}
						//inFromServer.skip(inFromServer.available());
						out.flush();
						System.out.println("sai daqui");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			        //try {
						//out.close();
						//inFromServer.close();
					//} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					//}
			        
			        //___________________segundo arquivo_______________________________
			        
			        try {
			            inFromServer =cliente.getInputStream();
			        } catch (IOException ex) {
			            System.out.println("Can't get socket input stream. ");
			        }

			        try {
			            out = new FileOutputStream("Historico2"+usuario);
			        } catch (FileNotFoundException ex) {
			            System.out.println("File not found. ");
			        }

			        bytes = new byte[16*1024];
			        
			        try {
						while ((count = inFromServer.read(bytes)) > 0) {
						    out.write(bytes, 0, count);
						    System.out.println("to acolá");
						    break;
						}
						out.flush();
						//inFromServer.skip(inFromServer.available());
						System.out.println("sai dacolá");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			        /*try {
						out.close();
						inFromServer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					
					Jogador objJogador = new Jogador(usuario, senha);
					TelaInicial ti = new TelaInicial(Cliente.frame, mapaUsuarios, objJogador, cliente);
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
		contentPane.setLayout(null);
		contentPane.add(btnEntrar);
		contentPane.add(lblSenha);
		contentPane.add(lblUsurio);
		contentPane.add(campoUsuario);
		contentPane.add(campoSenha);
		contentPane.add(btnEntrarComoConvidade);
		contentPane.add(btnNovoJogador);
		
		JLabel lblNewLabel = new JLabel("JOGO DA VELHA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(150, 91, 294, 33);
		contentPane.add(lblNewLabel);
	}
}