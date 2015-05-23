package ufpb.aps.ludo.excecoes;


public class JogadorInvalidoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public JogadorInvalidoException(String idJogador){
		super("ERRO:JOGADOR INVALIDO: "+idJogador);
	}
}
