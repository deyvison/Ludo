package ufpb.aps.ludo.modelo;

import java.util.ArrayList;

public class Ludo {
	
	//ArrayList<E> // lista com incremento circular para representar o jogadores
	private String tamDado;
	private String qtJogadores;
	private Tabuleiro tabuleiro;
	
	public Ludo(ArrayList<Casa> casasTabuleiro){

		this.tamDado =  descricaoTabuleiro.get(0); // obtem o tamanho do dado lido do arquivo
		descricaoTabuleiro.remove(0); // remove o tamDado do indice 0
		
		this.qtJogadores = descricaoTabuleiro.get(0); // obtem a qt de jogadores lida do arquivo
		descricaoTabuleiro.remove(0); // remove a qt de jogadores 
		
		this.tabuleiro = new Tabuleiro();
		
		this.carregarTabuleiro(casasTabuleiro);
	}
	
	private void carregarTabuleiro(ArrayList<Casa> casasTabuleiro){
			
			for(Casa c : casasTabuleiro){
				
				tabuleiro.addCasa(c); //parei aqui
			}
	}
	
}
