package jogo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

public class tRecebeCadastro implements Runnable{
	Socket cliente;
	String inputFromClient;
	String buffer[];
	Map<String, String> mapaU;
	
	public tRecebeCadastro(Socket cliente, Map<String, String> mapaU) {
		this.cliente=cliente;
		this.mapaU=mapaU;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//ObjectOutputStream outToClient = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream inFromClient = new ObjectInputStream(cliente.getInputStream());
				inputFromClient=(String)inFromClient.readObject();
				buffer=inputFromClient.split(":");
				new TratamentoDeUsuarios().cadastroEmArquivo(buffer[0], buffer[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
