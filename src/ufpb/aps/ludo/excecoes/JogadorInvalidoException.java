package ufpb.aps.ludo.excecoes;


public class JogadorInvalidoException extends Exception {
	
	public JogadorInvalidoException(String idJogador){
		super("ERRO:JOGADOR INVALIDO: "+idJogador);
	}
}
