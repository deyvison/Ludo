package ufpb.aps.ludo.facade;

import java.util.ArrayList;

import ufpb.aps.ludo.modelo.Casa;
import ufpb.aps.ludo.modelo.Ludo;

public class LudoFacade {
	
	
	private Ludo ludo;
	
	public LudoFacade(int tamDado, int qtJogadores) throws Exception{
		
		this.ludo = new Ludo(tamDado, qtJogadores);
	}
	
	
	public String jogar(String descricaoJogada){
		ludo.jogar(descricaoJogada);
		return "";
	}
	
	public void carregarTabuleiro(ArrayList<Casa> casasTabuleiro){
		ludo.carregarTabuleiro(casasTabuleiro);
	}
	
	
}
