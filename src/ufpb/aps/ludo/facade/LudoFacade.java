package ufpb.aps.ludo.facade;

import java.util.ArrayList;

import ufpb.aps.ludo.excecoes.JogadaInvalidaException;
import ufpb.aps.ludo.excecoes.JogadaMaximaException;
import ufpb.aps.ludo.excecoes.JogadorDaVezException;
import ufpb.aps.ludo.excecoes.JogadorInvalidoException;
import ufpb.aps.ludo.modelo.Casa;
import ufpb.aps.ludo.modelo.Ludo;

public class LudoFacade {
	
	private Ludo ludo;
	
	public LudoFacade(int tamDado, int qtJogadores) throws Exception{
		
		this.ludo = new Ludo(tamDado, qtJogadores);
	}
	
	
	public String jogar(String descricaoJogada) throws JogadorDaVezException, JogadaMaximaException, JogadaInvalidaException, JogadorInvalidoException{
		return ludo.jogar(descricaoJogada);
		
	}
	
	public void carregarTabuleiro(ArrayList<Casa> casasTabuleiro){
		ludo.carregarTabuleiro(casasTabuleiro);
	}
	
	public String getStatusDoJogo(){
		return this.ludo.getStatusDoJogo();
	}
	
}
