package ufpb.aps.ludo.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {
	
	private Map<String, Casa> tabuleiro;
	private Map<String,String> posicaoJogadores; // idJogador, casaAtual;
	private ArrayList<String> ids;
	
	public Tabuleiro(){
		
		this.tabuleiro = new HashMap<String, Casa>();
		this.posicaoJogadores = new HashMap<String,String>();
		this.ids = new ArrayList<String>();
	}
	
	public void addCasa(Casa c){
		this.tabuleiro.put(c.getID(), c);
		this.ids.add(c.getID());
	}
	
	public String mover(String IDjogador, int nDado){
		
		String idCasaAtual = this.posicaoJogadores.get(IDjogador); //id casa atual do jogador
		
		int posFinalArray = this.ids.indexOf(idCasaAtual)+nDado; // posicao da casa final do jogador
		
		String idCasaFinal = ids.get(posFinalArray); // id casa final do jogador
		
		Casa casaFinal = this.tabuleiro.get(idCasaFinal); //obtem casa final do jogador

		switch (casaFinal.getAcao()){ // verifica a ação da casa
			case "INICIO":
				// todos vao começar do inicio(impossivel cair aqui)
			case "NADA":
				// passa a vez para o proximo
			case "REPETE":
				// joga mais uma vez
			case "PARA":
				// fica uma rodada sem jogar
			case "VOLTA":
				// volta x casas
			case "AVANCA":
				// avança x casas
			case "IR_PARA":
				// vai para casa x
			case "FIM":
				// jogador ganhou - fim de jogo
				
		}
		
		posicaoJogadores.put(IDjogador, idCasaFinal); //atualiza a casa atual onde o jogador parou
		return "";
	}
	
	public void addJogador(String idJogador){
		this.posicaoJogadores.put(idJogador,this.ids.get(0)); // add cada jogador e o coloca na casa de inicio
		
	} 
	
	
	
}
