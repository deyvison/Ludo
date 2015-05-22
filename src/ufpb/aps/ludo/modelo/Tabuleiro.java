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
			this.posicaoJogadores.put(IDjogador, idCasaFinal); //atualiza a casa atual onde o jogador parou
			
			
			if(casaFinal.getAcao().equals("IR_PARA")){
				
				while(casaFinal.getAcao().equals("IR_PARA")){
					// pegar a casa seguinte - idproximacasa
					String casaFinalIR_Para = casaFinal.getIDProximaCasa();
					this.posicaoJogadores.put(IDjogador, casaFinalIR_Para);
					casaFinal = this.tabuleiro.get(casaFinalIR_Para);
				}
				
				
				return casaFinal.getAcao();
			}else{
				return casaFinal.getAcao();
			}
		}else{// se for maior ou igual, o jogador ganhou
			return "FIM"; // jogador ganhou
		}
	}
	
	public void addJogador(String idJogador){
		this.posicaoJogadores.put(idJogador,this.ids.get(0)); // add cada jogador e o coloca na casa de inicio
	} 
	
	public String getStatusDoJogo(){
		String retorno = "";
		for (String idJog  : this.posicaoJogadores.keySet()) {  
		    String posCasa = this.posicaoJogadores.get(idJog);
		    
		    retorno +=idJog+":"+posCasa+"/";
		}
		return retorno.substring(0, retorno.length()-1); // retornar o status do jogo (casa onde casa jogador está)
	}

	public boolean validaJogador(String jogador) {
		for(String idJog : this.posicaoJogadores.keySet()){
			if(idJog.equals(jogador)){
				return true;
			}
		}
		return false;
	}
	
	
}
