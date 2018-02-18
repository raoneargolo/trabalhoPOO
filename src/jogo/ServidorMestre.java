package jogo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServidorMestre {
    public static void main(String[] args) throws IOException {
    	Map<String, String> mapa;
    	LerUsuario lu;
        ServerSocket servidor = new ServerSocket(12346);
        System.out.println("Porta 12345 aberta!");
        Socket cliente;
        
        tIniciarPartida objIniciarPartida=new tIniciarPartida();
        
        while(true) {
        	lu = new LerUsuario();
        	
        	cliente = servidor.accept();
            System.out.println("Nova conex�o com o cliente " +     
                cliente.getInetAddress().getHostAddress()
            );
            
        	//cria um objeto que vai tratar a conex�o
            tInicioConexao tIni = new tInicioConexao(cliente, lu.lerUsuarios(), objIniciarPartida);
        	
            // cria a thread em cima deste objeto
            Thread threadInicio = new Thread(tIni);

            // inicia a thread
            threadInicio.start();

        }
        
        //servidor.close();
        //cliente.close();
    }
}