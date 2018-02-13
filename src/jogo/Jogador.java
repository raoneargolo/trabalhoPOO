package jogo;

import java.util.HashMap;
import java.util.Map;

public class Jogador {
    
    private String nomeUsuario;
    private String senhaJogador;
    private long quantidadeVitorias;
    private long quantidadeEmpates;
    private long quantidadeDerrotas;
    private HistoricoPartidas ultimosJogos;
    private Map<String, String> MapaHistoricoJogador;
    
    public Jogador() {
        MapaHistoricoJogador = new HashMap<String, String>();
        ultimosJogos = new HistoricoPartidas();
    }
    
    public Jogador(String nomeUsuario, String senhaJogador) {
        this.nomeUsuario = nomeUsuario;
        this.senhaJogador = senhaJogador;
        MapaHistoricoJogador = new HashMap<String, String>();
        ultimosJogos = new HistoricoPartidas();
        exibirHistorico();
        exibirNumerosJogador();
    }
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    
    public String getSenhaJogador() {
        return senhaJogador;
    }
    
    public long getQuantidadeVitorias() {
        return quantidadeVitorias;
    }
    
    public long getQuantidadeEmpates() {
        return quantidadeEmpates;
    }
    
    public long getQuantidadeDerrotas() {
        return quantidadeDerrotas;
    }
    
    public void exibirNumerosJogador() {
        ultimosJogos.recuperarNumeros(nomeUsuario);
        this.quantidadeVitorias = Integer.parseInt(ultimosJogos.getVitorias());
        this.quantidadeEmpates = Integer.parseInt(ultimosJogos.getEmpates());
        this.quantidadeDerrotas = Integer.parseInt(ultimosJogos.getDerrotas());
    }
    
    public Map<String,String> exibirHistorico() {
        MapaHistoricoJogador = ultimosJogos.recuperarHistorico(nomeUsuario);
        return MapaHistoricoJogador;
    }
    
    public void computarResultado(String adversario, String resultado) {
        MapaHistoricoJogador = ultimosJogos.getMapaHistorico();
        MapaHistoricoJogador.put(adversario, resultado);
        ultimosJogos.setMapaHistorico(MapaHistoricoJogador);
        ultimosJogos.armazenarHistorico(nomeUsuario);
        
        if(resultado.equalsIgnoreCase("Vitoria")){
            quantidadeVitorias++;
        }else if(resultado.equalsIgnoreCase("Empate")){
            quantidadeEmpates++;
        }else{
            quantidadeDerrotas++;
        }
        
        ultimosJogos.armazenarNumeros(nomeUsuario, quantidadeVitorias, quantidadeEmpates, quantidadeDerrotas);
    }
}
