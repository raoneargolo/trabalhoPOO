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
//    	JogoDaVelha objJogoDaVelha=null;
    	int contJogadores=0;
    	
        ServerSocket servidor = new ServerSocket(12346);
        System.out.println("Porta 12345 aberta!");
        Socket cliente;
        
        tIniciarPartida objIniciarPartida=null;
        
        while(true) {
        	lu = new LerUsuario();
        	
        	cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente " +     
                cliente.getInetAddress().getHostAddress()
            );
            
            if(contJogadores%2==0) {
            	objIniciarPartida=new tIniciarPartida();
//            	objJogoDaVelha=new JogoDaVelha();
            }
            contJogadores++;
            
        	//cria um objeto que vai tratar a conexão
            tInicioConexao tIni = new tInicioConexao(cliente, lu.lerUsuarios(), objIniciarPartida/*, objJogoDaVelha*/);
        	
            // cria a thread em cima deste objeto
            Thread threadInicio = new Thread(tIni);

            // inicia a thread
            threadInicio.start();

        }
        
        //servidor.close();
        //cliente.close();
    }
}