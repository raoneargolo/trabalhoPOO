package jogo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HistoricoPartidas {

    private final String Hist = "Historico";
    private final String Num = "Numeros";
    private String linha;
    private String adversario;
    private String resultado;
    private String vitorias;
    private String empates;
    private String derrotas;
    private Map<String, String> mapaHistorico;
    private File arquivoJogador;
    private boolean primeiro;
    Scanner fromFile;

    public HistoricoPartidas() {
        mapaHistorico = new HashMap<String, String>();
        primeiro = true;
    }

    public String getVitorias() {
        return vitorias;
    }

    public String getEmpates() {
        return empates;
    }

    public String getDerrotas() {
        return derrotas;
    }

    public Map<String, String> getMapaHistorico() {
        return mapaHistorico;
    }

    public void setMapaHistorico(Map<String, String> mapaHistorico) {
        this.mapaHistorico = mapaHistorico;
    }

    public void recuperarNumeros(String jogador) {
        try {
            fromFile = new Scanner(new File(Num + jogador));

            linha = fromFile.nextLine();
            String buff[] = linha.split(":");
            vitorias = buff[0];
            empates = buff[1];
            derrotas = buff[2];

        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistoricoPartidas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void armazenarNumeros(String jogador, long vitorias, long empates, long derrotas) {
        try {
            arquivoJogador = new File(Num + jogador);
            if (!arquivoJogador.exists()) {
                arquivoJogador.createNewFile();
            }

            FileWriter escrever = new FileWriter(arquivoJogador.getName(), false);
            BufferedWriter bw = new BufferedWriter(escrever);

            bw.write("" + vitorias);
            bw.write(":");
            bw.write("" + empates);
            bw.write(":");
            bw.write("" + derrotas);

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String,String> recuperarHistorico(String jogador) {
        try {
            fromFile = new Scanner(new File(Hist + jogador));
            while (fromFile.hasNextLine()) {
                linha = fromFile.nextLine();
                if(linha.equals("comeco")) {
                	continue;
                }
                String buff[] = linha.split(":");
                adversario = buff[0];
                resultado = buff[1];
                mapaHistorico.put(adversario, resultado);
                //System.out.println("Advers�rio: "+adversario+"\nResultado: "+resultado);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistoricoPartidas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapaHistorico;
    }

    public void armazenarHistorico(String jogador) {
        try {
            arquivoJogador = new File(Hist + jogador);
            if (!arquivoJogador.exists()) {
                arquivoJogador.createNewFile();
            }

            FileWriter escrever = new FileWriter(arquivoJogador.getName(), false);
            BufferedWriter bw = new BufferedWriter(escrever);
            
            bw.write("comeco");
            for (Map.Entry<String, String> mapabuffer : mapaHistorico.entrySet()) {
                    bw.write("\n" + mapabuffer.getKey());
                    bw.write(":");
                    bw.write(mapabuffer.getValue());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}