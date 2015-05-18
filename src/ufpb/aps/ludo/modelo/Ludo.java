package ufpb.aps.ludo.modelo;

import java.util.ArrayList;

import ufpb.aps.ludo.excecoes.JogadaInvalidaException;
import ufpb.aps.ludo.excecoes.JogadaMaximaException;
import ufpb.aps.ludo.excecoes.JogadorDaVezException;

public class Ludo {
	
	//ArrayList<E> // lista com incremento circular para representar o jogadores
	private int tamDado;
	private int qtJogadores;
	private Tabuleiro tabuleiro;
	
	private int jogadorDaVez = 1;
	
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
	
	public String jogar(String descricaoJogada) throws JogadorDaVezException, JogadaMaximaException, JogadaInvalidaException{
			
		String dados[];
			
		if(descricaoJogada.contains(">")){
			dados = descricaoJogada.split(">");
		}else{
			throw new JogadaInvalidaException();
		}
		
		boolean result = tabuleiro.validaJogador(dados[0]);
		if(!result){
			throw new JogadaInvalidaException();
		}
			
			
		boolean jog = dados[0].equalsIgnoreCase("J"+jogadorDaVez);
		
		if(!jog){
			throw new JogadorDaVezException("J"+jogadorDaVez);
		}
			
		int tamDadoRecebido;
			
		try{
			tamDadoRecebido = Integer.parseInt(dados[1]);
		}catch(Exception e){
			throw new JogadaInvalidaException();
		}
			
			
			
		if(tamDadoRecebido > tamDado){
			throw new JogadaMaximaException(this.tamDado);
		}
		
		if(tamDadoRecebido <= 0){
			throw new JogadaInvalidaException();
		}
		
		// se a jogada for menor ou igual a 0 e não conseguir converter pra int (jogadainvalida exception)
		String retorno = tabuleiro.mover(dados[0], tamDadoRecebido); // idjogador, numero do dado que tirou
		
		
		if(retorno.equals("NADA")){
			jogadorDaVez = (this.jogadorDaVez % this.qtJogadores) + 1; // passa a vez para o próximo jogador
			return this.tabuleiro.getStatusDoJogo(); // retorna o status do jogo se alguem nao ganhou ou se não houve algum erro
		
		}else if(retorno.equals("REPETE")){ // jogador joga mais uma vez
			jogadorDaVez = jogadorDaVez;
			return this.tabuleiro.getStatusDoJogo(); // retorna o status do jogo se alguem nao ganhou ou se não houve algum erro
			}else if(retorno.equals("PARA")){ // jogador fica uma vez sem jogar
			// fazer um jeito de ficar sem jogar por uma rodada
			return this.tabuleiro.getStatusDoJogo(); // retorna o status do jogo se alguem nao ganhou ou se não houve algum erro
		}else if(retorno.equals("FIM")){ // Fim de jogo
			return "FIM DE JOGO:VENCEDOR "+"J"+this.jogadorDaVez;
		}
		
		return "deu águia "+retorno;
}


	public void addJogadores(){
		for(int i = 1 ; i <= this.qtJogadores ; i++){
			this.tabuleiro.addJogador("J"+i);
		}
	}
	public String getStatusDoJogo() {
		return this.tabuleiro.getStatusDoJogo();
	}
	
}
