package ufpb.aps.ludo.modelo;

import java.util.ArrayList;

import ufpb.aps.ludo.excecoes.JogadaInvalidaException;
import ufpb.aps.ludo.excecoes.JogadaMaximaException;
import ufpb.aps.ludo.excecoes.JogadorDaVezException;
import ufpb.aps.ludo.excecoes.JogadorInvalidoException;

public class Ludo {
	
	private int tamDado;
	private int qtJogadores;
	private Tabuleiro tabuleiro;
	private ArrayList<Boolean> jogadorPodeJogar;
	
	private int jogadorDaVez;
	
	public Ludo(int tamDado,int qtJogadores){

		this.tabuleiro = new Tabuleiro();
		this.tamDado = tamDado;
		this.qtJogadores = qtJogadores;
		this.jogadorDaVez = 1;
		this.jogadorPodeJogar = new ArrayList<Boolean>(qtJogadores+1); // cria um array de boolean para representar que cada jogador pode jogar
		
	}
	
	public void carregarTabuleiro(ArrayList<Casa> casasTabuleiro){
			
			for(Casa c : casasTabuleiro){
				tabuleiro.addCasa(c);
			}
			this.addJogadores();
			this.setJogadoresPodemJogar();
	}
	
	private void setJogadoresPodemJogar(){
		int index = 0;
		while(index <= qtJogadores){
			this.jogadorPodeJogar.add(true);
			index++;
		}
	}

	public String jogar(String descricaoJogada) throws JogadorDaVezException, JogadaMaximaException, JogadaInvalidaException, JogadorInvalidoException{
			
		String dados[];
			
		if(descricaoJogada.contains(">")){
			dados = descricaoJogada.split(">");
		}else{
			throw new JogadaInvalidaException();
		}
		
		boolean result = tabuleiro.validaJogador(dados[0]);
		if(!result){
			throw new JogadorInvalidoException(dados[0]);
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
		
		
		
		if(this.jogadorPodeJogar.get(this.jogadorDaVez)){
			
			String retorno = tabuleiro.mover(dados[0], tamDadoRecebido); // idjogador, numero do dado que tirou
			if(retorno.equals("NADA")|| retorno.equals("INICIO")){
				jogadorDaVez = (this.jogadorDaVez % this.qtJogadores) + 1; // passa a vez para o próximo jogador
				return this.tabuleiro.getStatusDoJogo(); // retorna o status do jogo se alguem nao ganhou ou se não houve algum erro
			
			}else if(retorno.equals("REPETE")){ // jogador joga mais uma vez
				jogadorDaVez = jogadorDaVez;
				return this.tabuleiro.getStatusDoJogo(); // retorna o status do jogo se alguem nao ganhou ou se não houve algum erro
			}else if(retorno.equals("PARA")){ // jogador fica uma vez sem jogar
				
				this.jogadorPodeJogar.set(jogadorDaVez, false);
				jogadorDaVez = (this.jogadorDaVez % this.qtJogadores) + 1;
				return this.tabuleiro.getStatusDoJogo(); // retorna o status do jogo se alguem nao ganhou ou se não houve algum erro
			}else{ // Fim de jogo
				return "FIM DE JOGO:VENCEDOR "+"J"+this.jogadorDaVez;
			}
		}else{
			this.jogadorPodeJogar.set(jogadorDaVez, true);
			jogadorDaVez = (this.jogadorDaVez % this.qtJogadores) + 1;
			throw new JogadorDaVezException("J"+jogadorDaVez);
		}
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
