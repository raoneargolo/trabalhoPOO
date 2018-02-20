package jogo;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class tInicioConexao implements Runnable {
	Socket cliente;
	Map<String, String> mapaU;
	tIniciarPartida objIniciarPartida = null;
	String inputFromClient;
	String buffer[];
	JogoDaVelha objJogoDaVelha;

	public tInicioConexao(Socket cliente, Map<String, String> mapaU, tIniciarPartida objIniciarPartida,
			JogoDaVelha objJogoDaVelha) throws IOException {
		this.cliente = cliente;
		this.mapaU = mapaU;
		this.objIniciarPartida = objIniciarPartida;
		this.objJogoDaVelha = objJogoDaVelha;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ObjectOutputStream outToClient = new ObjectOutputStream(cliente.getOutputStream());
			outToClient.flush();
			// ObjectInputStream inFromClient = new
			// ObjectInputStream(cliente.getInputStream());
			outToClient.writeObject(mapaU);
			outToClient.flush();
			// outToClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner s;
		String subString;
		try {
			s = new Scanner(cliente.getInputStream());
			while (s.hasNextLine()) {

				inputFromClient = s.nextLine();

				if (inputFromClient.startsWith("cada")) {
					// TODO - CRIAR SUBSTRING PARA ENVIO PRO SERVIDOR
					subString = inputFromClient.substring(4);
					// System.out.println(inputFromClient);
					buffer = subString.split(":");
					System.out.println(buffer[0] + ":" + buffer[1]);
					new TratamentoDeUsuarios().cadastroEmArquivo(buffer[0], buffer[1]);

				} else if (inputFromClient.startsWith("arqu")) {
					subString = inputFromClient.substring(4);
					File arquivo;

					byte[] bytes;
					InputStream in;
					OutputStream outToClient;
					int count;

					arquivo = new File("Numeros" + subString);
					bytes = new byte[16 * 1024];

					outToClient = cliente.getOutputStream();
					in = new FileInputStream(arquivo);

					while ((count = in.read(bytes)) > 0) {
						outToClient.write(bytes, 0, count);
						System.out.println("to ali");
					}
					outToClient.flush();
					// outToClient.close();
					in.close();
					System.out.println("sai dali");

					// _______________________segundo arquivo___________________________________

					arquivo = new File("Historico" + subString);
					bytes = new byte[16 * 1024];

					in = new FileInputStream(arquivo);
					// OutputStream outToClient2;
					outToClient = cliente.getOutputStream();
					while ((count = in.read(bytes)) > 0) {
						outToClient.write(bytes, 0, count);
						System.out.println("to acá");
					}
					System.out.println("Saí d'acá");
					outToClient.flush();
					// outToClient.close();
					in.close();

				} else if (inputFromClient.startsWith("inic")) {
					//TODO Codar o metodo de envio de String para definir a jogada de cada jogador
					//flag que define de quem é a jogada
					//button pressed verifica flag, envia apenas se for a vez do jogador
					Jogador objJogador;
					boolean verificarC = true;

					ObjectInputStream inFromCliente = new ObjectInputStream(cliente.getInputStream());
					objJogador = (Jogador) inFromCliente.readObject();
					inFromCliente.skip(inFromCliente.available());
					
					objIniciarPartida.iniciarPartida(cliente, objJogador);
					
					while (verificarC) {
						if(objIniciarPartida.verificarComecou()) {
							verificarC=false;
						}
						System.out.print("");
							
					}
					
					objJogoDaVelha.Receberjogadores(objIniciarPartida.getObjJogador1(),objIniciarPartida.getObjJogador2());
					ObjectOutputStream outToClient = new ObjectOutputStream(cliente.getOutputStream());
					outToClient.writeObject(objJogoDaVelha);
					outToClient.flush();

				}
			}
			s.close();
		} catch (IOException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * try { //ObjectOutputStream outToClient = new
		 * ObjectOutputStream(cliente.getOutputStream()); ObjectInputStream inFromClient
		 * = new ObjectInputStream(cliente.getInputStream());
		 * inputFromClient=(String)inFromClient.readObject();
		 * buffer=inputFromClient.split(":"); new
		 * TratamentoDeUsuarios().cadastroEmArquivo(buffer[0], buffer[1]); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

	}
}