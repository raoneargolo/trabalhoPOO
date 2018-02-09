package jogo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Validacao {
	
	private static File arquivoUsuarios;
	
	public static boolean ValidacaoUsuarioSenha(String usuarioLogon, String senhaLogon) {
		
		boolean validador = false;
		
		Scanner verificarArquivo;

		try {
			verificarArquivo = new Scanner(new File("usuarios"));

			while (verificarArquivo.hasNextLine()) {

				String linhaArquivo = verificarArquivo.nextLine();

				String usuarioSenhaArquivo[] = linhaArquivo.split(":");
				
				String usuarioArquivo = usuarioSenhaArquivo[0];
				String senhaArquivo = usuarioSenhaArquivo[1];

				if (usuarioLogon.equals(usuarioArquivo) && senhaLogon.equals(senhaArquivo)) {
					validador = true;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (validador == true) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static boolean SenhaIgualConfirmarSenha (String senha, String confirmarSenha) {
		
		if(senha.equals(confirmarSenha)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static boolean ValidacaoUsuarioCadastro(String usuario) {
	
		boolean usuarioJaEncontrado = false;
		
		Scanner verificarArquivo;
		
		try {
			verificarArquivo = new Scanner(new File("usuarios"));
			
			while (verificarArquivo.hasNextLine()) {
			
				String linhaArquivo = verificarArquivo.nextLine();
				
				String usuarioSenhaArquivo[] = linhaArquivo.split(":");
				
				String usuarioArquivo = usuarioSenhaArquivo[0];
			
				if (usuario.equals(usuarioArquivo)) {
					usuarioJaEncontrado = true;
				}
			}
		} catch (FileNotFoundException erro) {
			erro.printStackTrace();
		}
		
		if (usuarioJaEncontrado == true) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public static void CadastrarUsuario(String usuario, String senha) {

		String novoUsuario = usuario + ":" + senha;

		try {
			arquivoUsuarios = new File("usuarios");
			if (!arquivoUsuarios.exists()) {
				arquivoUsuarios.createNewFile();
			}

		} catch (IOException erro) {
			erro.printStackTrace();
		}

		FileWriter escreverArquivo;
		
		try {
			escreverArquivo = new FileWriter(arquivoUsuarios.getName(), true);
			
			BufferedWriter bufferEscrita = new BufferedWriter(escreverArquivo);
			
			bufferEscrita.write(novoUsuario + "\n");
			
			bufferEscrita.close();
		} catch (IOException erro) {
			erro.printStackTrace();
		}
	}
}
