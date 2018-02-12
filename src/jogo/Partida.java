package jogo;

public class Partida {

	Usuario oponente1;
	Usuario oponente2;
	public Usuario getOponente1() {
		return oponente1;
	}
	public void setOponente1(Usuario oponente1) {
		this.oponente1 = oponente1;
	}
	public Usuario getOponente2() {
		return oponente2;
	}
	public void setOponente2(Usuario oponente2) {
		this.oponente2 = oponente2;
	}

	
	public void Ganhador(String ganhador , int statusVitoria) {
		Usuario auxOponente1 = this.getOponente1();
		Usuario auxOponente2 = this.getOponente2();
		
		if (auxOponente1.getCor()==ganhador ) {
			Jogo partida= new Jogo(auxOponente2.getUsuario(),1,statusVitoria);
			auxOponente1.setPartida(partida);
			
			Jogo partida2= new Jogo(auxOponente2.getUsuario(),1,statusVitoria);
			auxOponente2.setPartida(partida2);
		}
		
		if (auxOponente1.getCor()==ganhador){
			Jogo partida= new Jogo(auxOponente2.getUsuario(),1,statusVitoria);
			auxOponente2.setPartida(partida);
			
			Jogo partida2= new Jogo(auxOponente1.getUsuario(),1,statusVitoria);
			auxOponente2.setPartida(partida2);
		}
	}
	
	public void CriarPartida(String cor1, String cor2) {
		this.oponente1.setCor(cor1);
		this.oponente2.setCor(cor2);
	}
}
