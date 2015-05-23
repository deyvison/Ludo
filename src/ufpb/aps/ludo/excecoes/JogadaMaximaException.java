package ufpb.aps.ludo.excecoes;

public class JogadaMaximaException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public JogadaMaximaException(int tamDado){
		super("ERRO:JOGADA MAXIMA: "+tamDado);
	}
}
