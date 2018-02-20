package jogo;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaInicial extends JPanel {
	private JTextField Oponente1;
	private JTextField Oponente2;
	private JTextField Oponente3;
	private JTextField Oponente4;
	private JTextField Oponente5;
	private JTextField Oponente6;
	private JTextField Oponente7;
	private JTextField Oponente8;
	private JTextField Oponente10;
	private JTextField Oponente9;
	private JTextField resultado1;
	private JTextField resultado2;
	private JTextField resultado3;
	private JTextField resultado4;
	private JTextField resultado5;
	private JTextField resultado6;
	private JTextField resultado7;
	private JTextField resultado8;
	private JTextField resultado9;
	private JTextField resultado10;
	private JLabel lblVitoria;
	private JLabel lblEmpate;
	private JLabel lblDerrota;
	private JTextField Vitoria;
	private JTextField Empate;
	private JTextField Derrota;

	/**
	 * Create the panel.
	 */

	public TelaInicial(JFrame frame, Map<String, String> mapaUsuarios, Jogador objJogador, Socket cliente) {
		// public TelaInicial(Map<String,String> mapaUsuarios, Jogador objJogador) {
		String usuario;

		if (TelaLogon.usuario == null) {
			usuario = TelaCadastro.usuario;
		} else {
			usuario = TelaLogon.usuario;
		}

		JLabel nomeJogador = new JLabel(usuario);
		nomeJogador.setBounds(127, 34, 280, 49);
		nomeJogador.setFont(new Font("Tahoma", Font.PLAIN, 35));

		JLabel textoBemVindo = new JLabel("Bem vindo,");
		textoBemVindo.setBounds(26, 54, 105, 25);
		textoBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblJogos = new JLabel("Jogo");
		lblJogos.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogos.setBounds(26, 142, 49, 20);
		lblJogos.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblJogo_1 = new JLabel("1");
		lblJogo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJogo_1.setBounds(26, 170, 49, 14);

		JLabel lblJogo_2 = new JLabel("2");
		lblJogo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogo_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJogo_2.setBounds(26, 193, 49, 14);

		JLabel lblJogo_3 = new JLabel("3");
		lblJogo_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogo_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJogo_3.setBounds(26, 219, 49, 14);

		JLabel lblJogo_4 = new JLabel("4");
		lblJogo_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogo_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJogo_4.setBounds(26, 245, 49, 14);

		JLabel lblJogo_5 = new JLabel("5");
		lblJogo_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogo_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJogo_5.setBounds(26, 271, 49, 14);

		JLabel lblJogo_6 = new JLabel("6");
		lblJogo_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogo_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJogo_6.setBounds(26, 297, 49, 14);

		JLabel lblJogo_7 = new JLabel("7");
		lblJogo_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogo_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJogo_7.setBounds(26, 323, 49, 14);

		JLabel lblJogo_8 = new JLabel("8");
		lblJogo_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogo_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJogo_8.setBounds(26, 349, 49, 14);

		JLabel lblJogo_9 = new JLabel("9");
		lblJogo_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogo_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJogo_9.setBounds(26, 376, 49, 14);

		JLabel lblJogo_10 = new JLabel("10");
		lblJogo_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogo_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJogo_10.setBounds(26, 401, 50, 14);

		JLabel lblOponente = new JLabel("Oponente");
		lblOponente.setBounds(114, 144, 86, 17);
		lblOponente.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblResultados = new JLabel("Resultado");
		lblResultados.setBounds(243, 145, 86, 14);
		lblResultados.setFont(new Font("Tahoma", Font.BOLD, 16));

		Oponente1 = new JTextField();
		Oponente1.setBounds(110, 194, 90, 20);
		Oponente1.setEditable(false);
		Oponente1.setColumns(10);

		Oponente2 = new JTextField();
		Oponente2.setBounds(110, 220, 90, 20);
		Oponente2.setEditable(false);
		Oponente2.setColumns(10);

		Oponente3 = new JTextField();
		Oponente3.setBounds(110, 246, 90, 20);
		Oponente3.setEditable(false);
		Oponente3.setColumns(10);

		Oponente4 = new JTextField();
		Oponente4.setBounds(110, 272, 90, 20);
		Oponente4.setEditable(false);
		Oponente4.setColumns(10);

		Oponente5 = new JTextField();
		Oponente5.setBounds(110, 298, 90, 20);
		Oponente5.setEditable(false);
		Oponente5.setColumns(10);

		Oponente6 = new JTextField();
		Oponente6.setBounds(110, 324, 90, 20);
		Oponente6.setEditable(false);
		Oponente6.setColumns(10);

		Oponente7 = new JTextField();
		Oponente7.setBounds(110, 350, 90, 20);
		Oponente7.setEditable(false);
		Oponente7.setColumns(10);

		Oponente8 = new JTextField();
		Oponente8.setBounds(110, 376, 90, 20);
		Oponente8.setEditable(false);
		Oponente8.setColumns(10);

		Oponente10 = new JTextField();
		Oponente10.setBounds(110, 402, 90, 20);
		Oponente10.setEditable(false);
		Oponente10.setColumns(10);

		Oponente9 = new JTextField();
		Oponente9.setBounds(110, 168, 90, 20);
		Oponente9.setEditable(false);
		Oponente9.setColumns(10);

		resultado1 = new JTextField();
		resultado1.setBounds(266, 402, 30, 20);
		resultado1.setEditable(false);
		resultado1.setColumns(10);

		resultado2 = new JTextField();
		resultado2.setBounds(266, 376, 30, 20);
		resultado2.setEditable(false);
		resultado2.setColumns(10);

		resultado3 = new JTextField();
		resultado3.setBounds(266, 350, 30, 20);
		resultado3.setEditable(false);
		resultado3.setColumns(10);

		resultado4 = new JTextField();
		resultado4.setBounds(266, 324, 30, 20);
		resultado4.setEditable(false);
		resultado4.setColumns(10);

		resultado5 = new JTextField();
		resultado5.setBounds(266, 298, 30, 20);
		resultado5.setEditable(false);
		resultado5.setColumns(10);

		resultado6 = new JTextField();
		resultado6.setBounds(266, 272, 30, 20);
		resultado6.setEditable(false);
		resultado6.setColumns(10);

		resultado7 = new JTextField();
		resultado7.setBounds(266, 246, 30, 20);
		resultado7.setEditable(false);
		resultado7.setColumns(10);

		resultado8 = new JTextField();
		resultado8.setBounds(266, 220, 30, 20);
		resultado8.setEditable(false);
		resultado8.setColumns(10);

		resultado9 = new JTextField();
		resultado9.setBounds(266, 194, 30, 20);
		resultado9.setEditable(false);
		resultado9.setColumns(10);

		resultado10 = new JTextField();
		resultado10.setBounds(266, 168, 30, 20);
		resultado10.setEditable(false);
		resultado10.setColumns(10);

		lblVitoria = new JLabel("Vit\u00F3rias");
		lblVitoria.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVitoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVitoria.setBounds(370, 170, 61, 14);

		lblEmpate = new JLabel("Empates");
		lblEmpate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmpate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpate.setBounds(370, 222, 61, 14);

		lblDerrota = new JLabel("Derrotas");
		lblDerrota.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDerrota.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDerrota.setBounds(370, 248, 61, 14);

		Vitoria = new JTextField();
		Vitoria.setHorizontalAlignment(SwingConstants.CENTER);
		Vitoria.setBounds(441, 168, 20, 20);
		Vitoria.setColumns(10);
		Vitoria.setEditable(false);
		Vitoria.setText(Long.toString(objJogador.getQuantidadeVitorias()));

		// objJogador.exibirHistorico()
		Empate = new JTextField();
		Empate.setHorizontalAlignment(SwingConstants.CENTER);
		Empate.setBounds(441, 219, 20, 20);
		Empate.setColumns(10);
		Empate.setText(Long.toString(objJogador.getQuantidadeEmpates()));
		Empate.setEditable(false);

		Derrota = new JTextField();
		Derrota.setHorizontalAlignment(SwingConstants.CENTER);
		Derrota.setBounds(441, 246, 20, 20);
		Derrota.setColumns(10);
		Derrota.setText(Long.toString(objJogador.getQuantidadeDerrotas()));
		Derrota.setEditable(false);

		JButton btnIniciarpartida = new JButton("Iniciar partida");
		btnIniciarpartida.setBounds(186, 453, 127, 23);
		btnIniciarpartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new tEscritaGeral().enviarParaServidor(cliente, "inic");

				try {
					ObjectOutputStream outToServer = new ObjectOutputStream(cliente.getOutputStream());
					outToServer.writeObject(objJogador);
					outToServer.flush();

					JogoDaVelha tela;
					String buffer[];
					String escritaServidor;
					Scanner recebeAdversario;

					recebeAdversario = new Scanner(cliente.getInputStream());
					escritaServidor = recebeAdversario.nextLine();
					buffer = escritaServidor.split(":");
					System.out.println(buffer[0]+":"+buffer[1]);

					tela = new JogoDaVelha(cliente, buffer[0], objJogador, buffer[1]);

					tela.initialize();
					
					//cria um objeto que vai tratar a conexão
		            tRecebeAcaoServidor tRec = new tRecebeAcaoServidor(tela, cliente);
		        	
		            // cria a thread em cima deste objeto
		            Thread threadInicio = new Thread(tRec);

		            // inicia a thread
		            threadInicio.start();
					
					
//					String acaoServidor;
//					Scanner s;
//					s=new Scanner(cliente.getInputStream());
//					while(s.hasNextLine()) {
//						acaoServidor=s.nextLine();
//						new tRecebeAcaoServidor().executarAcaoServidor(tela, acaoServidor);
//					}
//					s.close();

					// ObjectInputStream inFromServer = new
					// ObjectInputStream(cliente.getInputStream());
					// JogoDaVelha tela = (JogoDaVelha)inFromServer.readObject();
					// inFromServer.skip(inFromServer.available());
					// tela.initialize();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} /*
					 * catch (ClassNotFoundException e) { // // TODO Auto-generated catch block //
					 * e.printStackTrace(); // }
					 */

				// JogoDaVelha JV = new JogoDaVelha(objJogador); // instancia panel
				// frame.setVisible(false); // deixa conteudo do panel atual desabilitado
				// //JV.setVisible(true); // deixa panel que eu quero habilitado
				// //setContentPane(JV); // insiro no panel do frame o panel que eu quero
				// //tc.setRequestFocusEnabled(true); // foca no panel que eu quero
			}
		});
		setLayout(null);
		add(nomeJogador);
		add(lblJogo_9);
		add(lblJogo_8);
		add(lblJogo_7);
		add(lblJogo_6);
		add(lblJogo_5);
		add(lblJogo_4);
		add(lblJogo_3);
		add(lblJogo_2);
		add(lblJogo_1);
		add(lblJogos);
		add(lblJogo_10);
		add(Oponente1);
		add(Oponente9);
		add(Oponente8);
		add(Oponente7);
		add(Oponente6);
		add(Oponente5);
		add(Oponente4);
		add(Oponente3);
		add(Oponente2);
		add(Oponente10);
		add(lblOponente);
		add(resultado1);
		add(resultado3);
		add(resultado5);
		add(resultado6);
		add(resultado7);
		add(resultado8);
		add(resultado10);
		add(resultado4);
		add(resultado9);
		add(resultado2);
		add(lblResultados);
		add(textoBemVindo);
		add(lblVitoria);
		add(lblEmpate);
		add(lblDerrota);
		add(Vitoria);
		add(Empate);
		add(Derrota);
		add(btnIniciarpartida);

	}
}