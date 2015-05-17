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
		
	}
	
	public void carregarTabuleiro(ArrayList<Casa> casasTabuleiro){
			
			for(Casa c : casasTabuleiro){
				tabuleiro.addCasa(c);
			}
			this.addJogadores();
	}
	
	public String jogar(String descricaoJogada){
		try{
			String dados[] = descricaoJogada.split(">");
			
			return tabuleiro.mover(dados[0], Integer.parseInt(dados[1])); // idjogador, numero do dado que tirou
			
		}catch(Exception e){
			return "JOGADA INVALIDA";
		}
	}
	
	public void addJogadores(){
		for(int i = 1 ; i <= this.qtJogadores ; i++){
			this.tabuleiro.addJogador("J"+i);
		}
	}
}
