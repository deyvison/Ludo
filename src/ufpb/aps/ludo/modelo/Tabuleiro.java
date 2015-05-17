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
		
		
		// verificar se a posicao final é maior do que a ultima casa do array (jogador ganhou)
		if(posFinalArray < ids.size()){
			
			String idCasaFinal = ids.get(posFinalArray); // id casa final do jogador
			
			Casa casaFinal = this.tabuleiro.get(idCasaFinal); //obtem casa final do jogador
			
			switch (casaFinal.getAcao()){ // verifica a ação da casa
			case "INICIO":
				// todos vao começar do inicio(impossivel cair aqui)
				break;
			case "NADA":
				// passa a vez para o proximo
				break;
			case "REPETE":
				// joga mais uma vez
				break;
			case "PARA":
				// fica uma rodada sem jogar
				break;
			case "IR_PARA":
				// vai para casa x	
				break;
			case "FIM":
				// jogador ganhou - fim de jogo
				break;
			}
			posicaoJogadores.put(IDjogador, idCasaFinal); //atualiza a casa atual onde o jogador parou
			
		}else{// se for maior ou igual, o jogador ganhou
			System.out.println("ganhou "+IDjogador); // jogador ganhou
		}
		

		String retorno = "";
		
		for (String idJog  : this.posicaoJogadores.keySet()) {  
		    String posCasa = this.posicaoJogadores.get(idJog);
		    
		    retorno +=idJog+":"+posCasa+"/";
		}
		return retorno; // retornar o status do jogo (casa onde casa jogador está)
	}
	
	public void addJogador(String idJogador){
		this.posicaoJogadores.put(idJogador,this.ids.get(0)); // add cada jogador e o coloca na casa de inicio
		
	} 
	
	
	
}
