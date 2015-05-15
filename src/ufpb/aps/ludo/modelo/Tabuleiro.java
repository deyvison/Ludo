package ufpb.aps.ludo.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {
	
	private Map<String, Casa> tabuleiro;
	private Map<Integer,String> posicaoJogadores; // idJogador, casaAtual;
	private Collection<String> ids;
	
	public Tabuleiro(){
		
		this.tabuleiro = new HashMap<String, Casa>();
		this.posicaoJogadores = new HashMap<Integer,String>();
		this.ids = new ArrayList<String>();
	}
	
	public void addCasa(Casa c){
		this.tabuleiro.put(c.getID(), c);
		this.ids.add(c.getID());
	}
	
	public void mover(int IDjogador, int nDado){
		
		String posAtual = this.posicaoJogadores.get(IDjogador);

		for(int i = 0 ; i < nDado ; i++){
			String prox = this.tabuleiro.get(posAtual).getIDProximaCasa();
		}
	}
	
	public void addJogador(int idJogador){
		this.posicaoJogadores.put(idJogador,"INICIO");
	
	} 
	
	public void atribuirAcoes(){
		
		for(String id : this.ids){
			String acao = this.tabuleiro.get(id).getAcao();
			
			if(acao !)
		}
	}
	
}
