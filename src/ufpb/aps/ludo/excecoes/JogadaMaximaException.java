package ufpb.aps.ludo.excecoes;

public class JogadaMaximaException extends Exception{
	
	public JogadaMaximaException(int tamDado){
		super("ERRO:JOGADA MAXIMA: "+tamDado);
	}
}
