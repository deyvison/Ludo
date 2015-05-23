package ufpb.aps.ludo.excecoes;

public class JogadorDaVezException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public JogadorDaVezException(String jogadorDaVez){
		
		super("ERRO:JOGADOR DA VEZ: "+ jogadorDaVez);
	}
	
	

}
