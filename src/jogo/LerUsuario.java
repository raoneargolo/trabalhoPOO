package jogo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LerUsuario {

	private File arquivoUsuarios;
	private Map<String, String> mapa = new HashMap<String, String>();

	public Map<String, String> lerUsuarios() {
		
		Scanner verificarArquivo;

		try {
			verificarArquivo = new Scanner(new File("usuarios"));

			while (verificarArquivo.hasNextLine()) {

				String linhaArquivo = verificarArquivo.nextLine();

				String usuarioSenhaArquivo[] = linhaArquivo.split(":");
				
				String usuarioArquivo = usuarioSenhaArquivo[0];
				String senhaArquivo = usuarioSenhaArquivo[1];
				mapa.put(usuarioArquivo, senhaArquivo);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mapa;
}
}
