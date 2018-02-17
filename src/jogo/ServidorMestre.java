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
        
        while(true) {
        	lu = new LerUsuario();
        	
        	cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente " +     
                cliente.getInetAddress().getHostAddress()
            );
            
            //mapa=lu.lerUsuarios();
        	//cria um objeto que vai tratar a conexão
            tInicioConexao tIni = new tInicioConexao(cliente, lu.lerUsuarios());
        	
            // cria a thread em cima deste objeto
            Thread threadInicio = new Thread(tIni);

            // inicia a thread
            threadInicio.start();
            
          //cria um objeto que vai tratar cadastro de arquivo
            tRecebeCadastro tCad = new tRecebeCadastro(cliente, lu.lerUsuarios());
        	
            // cria a thread em cima deste objeto
            Thread threadCadastro = new Thread(tCad);

            // inicia a thread
            threadCadastro.start();
        }
        
        //servidor.close();
        //cliente.close();
    }
}