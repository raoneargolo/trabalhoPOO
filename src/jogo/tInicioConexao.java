package jogo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class tInicioConexao implements Runnable {
	Socket cliente;
	Map<String, String> mapaU;
	String inputFromClient;
	String buffer[];

	public tInicioConexao(Socket cliente, Map<String, String> mapaU) throws IOException {
		this.cliente = cliente;
		this.mapaU = mapaU;
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner s;
		try {
			s = new Scanner(cliente.getInputStream());
			while (s.hasNextLine()) {
				inputFromClient=s.nextLine();
				System.out.println(inputFromClient);
				buffer=inputFromClient.split(":");
				System.out.println(buffer[0]+":"+buffer[1]);
				new TratamentoDeUsuarios().cadastroEmArquivo(buffer[0], buffer[1]);
			}
		} catch (IOException e1) {
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