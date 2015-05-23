package ufpb.aps.ludo.excecoes;

public class JogadaInvalidaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public JogadaInvalidaException(){
		super("ERRO:JOGADA INVALIDA");
	}
}
