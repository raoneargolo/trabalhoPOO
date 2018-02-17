package jogo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class tEscritaGeral {
	
	public void enviarParaServidor(Socket cliente, String conteudo) {
		Scanner entrada = new Scanner(conteudo);
		try {
			PrintStream saida = new PrintStream(cliente.getOutputStream());
			saida.println(entrada.nextLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		entrada.close();
	}
}
