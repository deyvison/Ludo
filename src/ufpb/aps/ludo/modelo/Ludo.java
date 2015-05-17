package ufpb.aps.ludo.modelo;

import java.util.ArrayList;

public class Ludo {
	
	//ArrayList<E> // lista com incremento circular para representar o jogadores
	private int tamDado;
	private int qtJogadores;
	private Tabuleiro tabuleiro;
	
	public Ludo(int tamDado,int qtJogadores){

		this.tabuleiro = new Tabuleiro();
		this.tamDado = tamDado;
		this.qtJogadores = qtJogadores;
		
		this.addJogadores();
	}
	
	public void carregarTabuleiro(ArrayList<Casa> casasTabuleiro){
			
			for(Casa c : casasTabuleiro){
				tabuleiro.addCasa(c);
			}
	}
	
	public String jogar(String descricaoJogada){
		String dados[] = descricaoJogada.split(">");
		tabuleiro.mover(dados[0], Integer.parseInt(dados[1]));
		return "";
	}
	
	public void addJogadores(){
		for(int i = 1 ; i <= this.qtJogadores ; i++){
			this.tabuleiro.addJogador("J"+i);
		}
	}
}
