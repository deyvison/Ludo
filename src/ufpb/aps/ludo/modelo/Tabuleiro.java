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
				// pegar a casa seguinte - idproximacasa
				String casaFinalIR_Para = casaFinal.getIDProximaCasa();
				this.posicaoJogadores.put(IDjogador, casaFinalIR_Para);
				return "NADA";
				
			}else if(casaFinal.getAcao().equals("VOLTA")){ // volta x casas, atualiza a posicao atual do jogador e depois retorna nada
				
				int indexVoltaPara = posFinalArray - Integer.parseInt(casaFinal.getIDProximaCasa()); // diminui a casa atual para a qt de casas que deve voltar
				
				if(indexVoltaPara < 0){
					idCasaFinal = this.ids.get(0); // obtem o id da casa final depois de x casas voltadas
				}else{
					idCasaFinal = this.ids.get(indexVoltaPara); // obtem o id da casa final depois de x casas voltadas
				}
				
				this.posicaoJogadores.put(IDjogador,idCasaFinal); // atualiza a posicao atual do jogador
				return "NADA"; // depois de fazer tudo isso, retorna NADA para passar a vez pro proximo jogador
				
			}else if(casaFinal.getAcao().equals("AVANCA")){ // avança x casas, atualiza a posicao atual do jogador e depois retorna nada

				int indexAvancaPara = posFinalArray + Integer.parseInt(casaFinal.getIDProximaCasa()); // soma a casa atual para a qt de casas que deve avançar
				
				if(indexAvancaPara >= this.ids.size()-1){ //-1
					return "FIM";
				}else{
					idCasaFinal = this.ids.get(indexAvancaPara); // obtem o id da casa final depois dos x avanços
				}
				
				this.posicaoJogadores.put(IDjogador,idCasaFinal); // atualiza a posicao atual do jogador
				return "NADA"; // depois de fazer tudo isso, retorna NADA para passar a vez pro proximo jogador
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
