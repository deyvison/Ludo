package ufpb.aps.ludo.modelo;

import java.util.ArrayList;

import ufpb.aps.ludo.enumAcoes.Acao;
import ufpb.aps.ludo.excecoes.JogadaInvalidaException;
import ufpb.aps.ludo.excecoes.JogadaMaximaException;
import ufpb.aps.ludo.excecoes.JogadorDaVezException;
import ufpb.aps.ludo.excecoes.JogadorInvalidoException;

public class Ludo {
	
	private int tamDado, qtJogadores, jogadorDaVez;
	private Tabuleiro tabuleiro;
	private ArrayList<Boolean> jogadorPodeJogar;
	
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

	public String jogar(String descricaoJogada) throws JogadorDaVezException, JogadaMaximaException, 
	JogadaInvalidaException, JogadorInvalidoException{
			
		boolean jog = this.validaJogador(descricaoJogada); // valida jogador
			
		if(jog){// se ele é o jogador da vez

			if(this.jogadorPodeJogar.get(this.jogadorDaVez)){ // se ele pode jogar, então joga
				
				String[] dadosJogada = this.validaJogada(descricaoJogada); // valida jogada
				Acao retorno = tabuleiro.mover(dadosJogada[0], Integer.parseInt(dadosJogada[1])); // idjogador, numero do dado que tirou
				
				if(retorno.equals(Acao.FIM)){
					return "FIM DE JOGO:VENCEDOR "+"J"+this.jogadorDaVez;
				}else{
					if(retorno.equals(Acao.NADA)|| retorno.equals(Acao.INICIO)){
						this.jogadorDaVez = (this.jogadorDaVez % this.qtJogadores) + 1; // passa a vez para o próximo jogador
					}else if(retorno.equals(Acao.REPETE)){
						this.jogadorDaVez = jogadorDaVez;
					}else if(retorno.equals(Acao.PARA)){
						this.jogadorPodeJogar.set(jogadorDaVez, false);
						jogadorDaVez = (this.jogadorDaVez % this.qtJogadores) + 1;
					}
					return this.tabuleiro.getStatusDoJogo(); // retorna o status do jogo se alguem nao ganhou ou se não houve algum erro
				}
			}else{ // se ele nao pode jogar
				this.jogadorPodeJogar.set(jogadorDaVez, true); // muda pra true pra ele poder jogar na próxima rodada
				jogadorDaVez = (this.jogadorDaVez % this.qtJogadores) + 1;
				throw new JogadorDaVezException("J"+jogadorDaVez); // só pode mudar pra true quando completar uma jogada
			}
		}else{ // se ele não for o jogador da vez
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

	private String[] validaJogada(String descricaoJogada) throws JogadaInvalidaException, JogadaMaximaException {

		String dados[];
		dados = descricaoJogada.split(">");
		int tamDadoRecebido;

		try{
			tamDadoRecebido = Integer.parseInt(dados[1]);
		}catch(Exception e){
			throw new JogadaInvalidaException();
		}
			
		if(tamDadoRecebido > tamDado) throw new JogadaMaximaException(this.tamDado);
		if(tamDadoRecebido <= 0) throw new JogadaInvalidaException();
		
		return dados;
	}

	private boolean validaJogador(String descricaoJogada) throws JogadaInvalidaException, JogadorInvalidoException {

		String dados[];
		
		if(descricaoJogada.contains(">")) dados = descricaoJogada.split(">");
		else throw new JogadaInvalidaException();
		
		boolean result = tabuleiro.validaJogador(dados[0]);
		
		if(!result) throw new JogadorInvalidoException(dados[0]);
		
		return dados[0].equalsIgnoreCase("J"+jogadorDaVez);
	}
}
