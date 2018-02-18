package jogo;

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
			outToClient.flush();
			outToClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner s;
		String subString;
		try {
			s = new Scanner(cliente.getInputStream());
			while (s.hasNextLine()) {
								
				inputFromClient=s.nextLine();
				
				if(inputFromClient.startsWith("cada")) {
					//TODO - CRIAR SUBSTRING PARA ENVIO PRO SERVIDOR
					subString=inputFromClient.substring(4);
					//System.out.println(inputFromClient);
					buffer=subString.split(":");
					System.out.println(buffer[0]+":"+buffer[1]);
					new TratamentoDeUsuarios().cadastroEmArquivo(buffer[0], buffer[1]);
					
				}else if(inputFromClient.startsWith("arqu")) {
					subString=inputFromClient.substring(4);
					File arquivo;
					
					arquivo = new File("Numeros"+subString);
					byte[] bytes = new byte[16*1024];
					
					InputStream in = new FileInputStream(arquivo);
					OutputStream outToClient;
					outToClient=cliente.getOutputStream();

					int count;
			        while ((count = in.read(bytes)) > 0) {
			            outToClient.write(bytes, 0, count);
			        }
			        
			        in.close();
			        outToClient.close();			        
				}
			}
			s.close();
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