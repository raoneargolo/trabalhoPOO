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
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

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
	
	public TelaInicial(JFrame frame) {
		String usuario;
		
		if(TelaLogon.usuario == null)
		{
			usuario = TelaCadastro.usuario;
		} else {
			usuario = TelaLogon.usuario;
		}
		
		JLabel lblNewLabel = new JLabel(usuario);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel lblNewLabel_1 = new JLabel(", bem vindo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaCadastro tC = new TelaCadastro(frame);
				frame.setContentPane(tC);
			}
		});
		
		JLabel lblJogos = new JLabel("Jogos");
		lblJogos.setFont(lblJogos.getFont().deriveFont(lblJogos.getFont().getStyle() | Font.BOLD));
		
		JLabel lblJogo_1 = new JLabel("Jogo 1");
		
		JLabel lblJogo_2 = new JLabel("Jogo 2");
		
		JLabel lblJogo_3 = new JLabel("Jogo 3");
		
		JLabel lblJogo_4 = new JLabel("Jogo 4");
		
		JLabel lblJogo_5 = new JLabel("Jogo 5");
		
		JLabel lblJogo_6 = new JLabel("Jogo 6");
		
		JLabel lblJogo_7 = new JLabel("Jogo 7");
		
		JLabel lblJogo_8 = new JLabel("Jogo 8");
		
		JLabel lblJogo_9 = new JLabel("Jogo 9");
		
		JLabel lblJogo_10 = new JLabel("Jogo 10");
		
		JLabel lblOponente = new JLabel("Oponente");
		lblOponente.setFont(lblJogos.getFont().deriveFont(lblJogos.getFont().getStyle() | Font.BOLD));
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setFont(lblJogos.getFont().deriveFont(lblJogos.getFont().getStyle() | Font.BOLD));
		
		Oponente1 = new JTextField();
		Oponente1.setColumns(10);
		
		Oponente2 = new JTextField();
		Oponente2.setColumns(10);
		
		Oponente3 = new JTextField();
		Oponente3.setColumns(10);
		
		Oponente4 = new JTextField();
		Oponente4.setColumns(10);
		
		Oponente5 = new JTextField();
		Oponente5.setColumns(10);
		
		Oponente6 = new JTextField();
		Oponente6.setColumns(10);
		
		Oponente7 = new JTextField();
		Oponente7.setColumns(10);
		
		Oponente8 = new JTextField();
		Oponente8.setColumns(10);
		
		Oponente10 = new JTextField();
		Oponente10.setColumns(10);
		
		Oponente9 = new JTextField();
		Oponente9.setColumns(10);
		
		resultado1 = new JTextField();
		resultado1.setColumns(10);
		
		resultado2 = new JTextField();
		resultado2.setColumns(10);
		
		resultado3 = new JTextField();
		resultado3.setColumns(10);
		
		resultado4 = new JTextField();
		resultado4.setColumns(10);
		
		resultado5 = new JTextField();
		resultado5.setColumns(10);
		
		resultado6 = new JTextField();
		resultado6.setColumns(10);
		
		resultado7 = new JTextField();
		resultado7.setColumns(10);
		
		resultado8 = new JTextField();
		resultado8.setColumns(10);
		
		resultado9 = new JTextField();
		resultado9.setColumns(10);
		
		resultado10 = new JTextField();
		resultado10.setColumns(10);
		
		lblVitoria = new JLabel("Vit\u00F3ria");
		
		lblEmpate = new JLabel("Empate");
		
		lblDerrota = new JLabel("Derrota");
		
		Vitoria = new JTextField();
		Vitoria.setColumns(10);
		
		Empate = new JTextField();
		Empate.setColumns(10);
		
		Derrota = new JTextField();
		Derrota.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(7)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblJogo_9)
											.addComponent(lblJogo_8)
											.addComponent(lblJogo_7)
											.addComponent(lblJogo_6)
											.addComponent(lblJogo_5)
											.addComponent(lblJogo_4)
											.addComponent(lblJogo_3)
											.addComponent(lblJogo_2)
											.addComponent(lblJogo_1)
											.addComponent(lblJogos))
										.addComponent(lblJogo_10))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(Oponente1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Oponente9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Oponente8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Oponente7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Oponente6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Oponente5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Oponente4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Oponente3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Oponente2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Oponente10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(140)
							.addComponent(lblOponente)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(resultado1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(resultado3, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(resultado5, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(resultado6, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(resultado7, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(resultado8, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(resultado9, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(resultado10, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(resultado2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
								.addComponent(resultado4, 0, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblDerrota)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(Derrota, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(Vitoria, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblVitoria, Alignment.LEADING))
										.addComponent(Empate, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
									.addGap(30))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblEmpate)
									.addGap(71))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblResultados)
								.addComponent(lblNewLabel_1))
							.addContainerGap(191, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(211)
					.addComponent(btnVoltar)
					.addContainerGap(256, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOponente)
						.addComponent(lblJogos)
						.addComponent(lblResultados))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(23)
									.addComponent(Oponente1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Oponente2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Oponente3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Oponente4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Oponente5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Oponente6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Oponente7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Oponente8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(Oponente9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Oponente10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnVoltar))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(resultado2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(resultado10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVitoria))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(resultado9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Vitoria))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(resultado8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmpate))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(resultado7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(resultado6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(Empate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(resultado5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDerrota))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(resultado4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(resultado3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(resultado1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(22)
									.addComponent(Derrota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(58))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(23)
									.addComponent(lblJogo_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblJogo_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblJogo_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblJogo_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblJogo_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblJogo_7)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblJogo_8)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblJogo_9))
								.addComponent(lblJogo_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblJogo_10)
							.addGap(68)))
					.addGap(17))
		);
		setLayout(groupLayout);

	}
}
