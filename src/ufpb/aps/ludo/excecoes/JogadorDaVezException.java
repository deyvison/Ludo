package ufpb.aps.ludo.excecoes;

public class JogadorDaVezException extends Exception{
	
	public JogadorDaVezException(String jogadorDaVez){
		
		super("ERRO:JOGADOR DA VEZ: "+ jogadorDaVez);
	}
	
	

}
