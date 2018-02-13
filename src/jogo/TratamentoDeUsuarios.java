package jogo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class TratamentoDeUsuarios {
	private File arquivoJogador;
	private File dadosJogador;
	
	public int verificarLogin(String usuario,String senha, HashMap<String, String> mapa) {
		if(mapa.containsKey(usuario)&&mapa.get(usuario).equals(senha)) {
			return 1;
		}else if(mapa.containsKey(usuario)&&!mapa.get(usuario).equals(senha)){
			return 0;
		}
		return -1;
	}
	
	public boolean cadastrarJogador(String usuario,String senha, HashMap<String, String> mapa) {
		if(mapa.containsKey(usuario))
			return false;
		else {
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
		            }
		            
			 } catch (IOException e) {
		            e.printStackTrace();
		     }
			return true;
		}
	}
	
	public String gerarVisitante(HashMap<String,String> mapa) {
		verificarLogin("guest","guest",mapa);
		return "Guest";
	}
}
