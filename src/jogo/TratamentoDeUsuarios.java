package jogo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TratamentoDeUsuarios {
	private File arquivoJogador;
	private File dadosJogador;

	public int verificarLogin(String usuario, String senha, Map<String, String> mapa) {
		if (mapa.containsKey(usuario) && mapa.get(usuario).equals(senha)) {
			return 1;
		} else if (mapa.containsKey(usuario) && !mapa.get(usuario).equals(senha)) {
			return 0;
		}
		return -1;
	}

	public boolean SenhaIgualConfirmarSenha(String senha, String confirmarSenha) {

		if (senha.equals(confirmarSenha)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ValidacaoUsuarioCadastro(String usuario, Map<String, String> mapa) {
		boolean usuarioJaEncontrado = true;
		if (mapa.containsKey(usuario)) {
			usuarioJaEncontrado = false;
		}
		return usuarioJaEncontrado;
	}

	public boolean cadastrarJogador(String usuario, String senha, Map<String, String> mapa) {
		mapa.put(usuario, senha);
		try {
			arquivoJogador = new File("Historico" + usuario);
			if (!arquivoJogador.exists()) {
				arquivoJogador.createNewFile();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			dadosJogador = new File("Numeros" + usuario);
			if (!dadosJogador.exists()) {
				dadosJogador.createNewFile();
				FileWriter escrever = new FileWriter(dadosJogador.getName(), false);
				BufferedWriter bw = new BufferedWriter(escrever);

				bw.write("" + 0);
				bw.write(":");
				bw.write("" + 0);
				bw.write(":");
				bw.write("" + 0);
				bw.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		cadastroEmArquivo(usuario, senha);
		return true;
	}
	
	public void cadastroEmArquivo(String usuario, String senha) {
		try {
			dadosJogador = new File("usuarios");
			FileWriter escrever = new FileWriter(dadosJogador.getName(), true);
			BufferedWriter bw = new BufferedWriter(escrever);
			bw.write("\n"+usuario +":" +senha);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String gerarVisitante(Map<String, String> mapa) {
		verificarLogin("guest", "guest", mapa);
		return "guest";
	}
}