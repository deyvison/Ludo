package ufpb.aps.ludo.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {
	
	private Map<String, Casa> tabuleiro;
	private Map<Integer,String> posicaoJogadores; // idJogador, casaAtual;
	private ArrayList<String> ids;
	
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
		
		String idCasaAtual = this.posicaoJogadores.get(IDjogador);
		
		int posFinalArray = this.ids.indexOf(idCasaAtual)+nDado;
		
		String idCasaFinal = ids.get(posFinalArray);
		
		Casa casaFinal = this.tabuleiro.get(idCasaFinal);

		switch (casaFinal.getAcao()){ // verifica a ação da casa
			case "INICIO":	
			case "NADA":
			case "REPETE":
			case "PARA":
			case "VOLTA":
			case "AVANCA":
			case "IR_PARA":
			case "FIM":
				
		}
			
			
			// alterar a posicao atual do jogador após ele terminar de jogar
			
		posicaoJogadores.put(IDjogador, idCasaFinal);
	}
	
	public void addJogador(int idJogador){
		this.posicaoJogadores.put(idJogador,"INICIO");
	
	} 
	
	public void atribuirAcoes(){
		
		for(String id : this.ids){
			String acao = this.tabuleiro.get(id).getAcao();
			
		//	if(acao !)
		}
	}
	
}
