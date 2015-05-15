package ufpb.aps.ludo.modelo;

import java.util.ArrayList;

public class Ludo {
	
	//ArrayList<E> // lista com incremento circular para representar o jogadores
	private String tamDado;
	private String qtJogadores;
	private Tabuleiro tabuleiro;
	
	public Ludo(ArrayList<Casa> casasTabuleiro){

		this.tabuleiro = new Tabuleiro();
		
		this.carregarTabuleiro(casasTabuleiro);
	}
	
	private void carregarTabuleiro(ArrayList<Casa> casasTabuleiro){
			
			for(Casa c : casasTabuleiro){
				tabuleiro.addCasa(c); //parei aqui
			}
	}
	
}
