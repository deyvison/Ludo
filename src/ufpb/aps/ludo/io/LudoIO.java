package ufpb.aps.ludo.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import ufpb.aps.ludo.excecoes.JogadorDaVezException;
import ufpb.aps.ludo.facade.LudoFacade;
import ufpb.aps.ludo.modelo.Casa;

public class LudoIO {
	
	private ArrayList<String> jogadas;
	private BufferedReader leitor;
	private PrintWriter escritor;
	private LudoFacade lf;
	
	public LudoIO(String arquivoEntrada, String arquivoSaida) throws Exception{
	
		this.leitor = new BufferedReader(new FileReader(arquivoEntrada));
		this.escritor = new PrintWriter(new FileWriter(arquivoSaida));
		this.jogadas = new ArrayList<String>();
		
		
		ArrayList<Casa> casas =this.lerArquivo(); 
	
		
		
		int nDado = Integer.parseInt(this.jogadas.get(0).split(":")[1]); // obtem o tamanho do dado que está no inicio do array de jogadas
		this.jogadas.remove(0); // remove da lista de jogadas
		
		int qtJogadores = Integer.parseInt(this.jogadas.get(0).split(":")[1]); // obtem a qt de jogadores
		this.jogadas.remove(0); // remove a qt de jogadores do array de jogadas
		
		
		this.lf = new LudoFacade(nDado, qtJogadores); // primeiro adc as casas
		lf.carregarTabuleiro(casas); // depois add os jogadores
	}
	
	public ArrayList<Casa> lerArquivo() throws Exception{
		
		ArrayList<String> especificacoesCasas = this.carregaTabuleiro();
		this.carregaJogadas();
		ArrayList<Casa> casas =	this.criarCasas(especificacoesCasas);
		return casas;
	}
	
	public ArrayList<String> carregaTabuleiro() throws Exception{
		ArrayList<String> especificacaoCasas = new ArrayList<String>();
		String linha = null;
		
		linha = leitor.readLine();
		
		while(!linha.toUpperCase().contains("FIM_TABULEIRO")){ // loop das especificações
			
			if(linha != null)
					if(!linha.startsWith("#"))
						especificacaoCasas.add(linha);
			linha = leitor.readLine();
		}
		return especificacaoCasas;
	}
	
	public void carregaJogadas() throws Exception{
		String linha = null;
		
		do{
			linha = leitor.readLine();
			if(linha != null)
				if(!linha.startsWith("#"))
					jogadas.add(linha);
		}while(linha != null);// loop das jogadas
	}
	
	public void escreverArquivo(String linha){
		this.escritor.println(linha);
	}
	
	public ArrayList<Casa> criarCasas(ArrayList<String> especificacaoCasas){
		
		ArrayList<Casa> casas = new ArrayList<Casa>();
		for(String s : especificacaoCasas){
			
			String id="", acao = "", idProximaCasa = null;
			String dados[] = s.split(":");
			
			if(dados.length == 3){
				id = dados[0]; 
				acao = dados[1];
				idProximaCasa = dados[2];
			}else{
				id = dados[0];
				acao = dados[1];
			}
			casas.add(new Casa(id,acao,idProximaCasa));
		}
		return casas;
	}

	public void iniciarJogo() throws JogadorDaVezException {
		String jogada = "";
		String retorno = "";
		
		for(String s : this.jogadas){
			jogada = s;
			try{
				retorno = lf.jogar(jogada);
				this.escreverArquivo(jogada);
				this.escreverArquivo("JOGO>"+retorno);
				
			}catch(Exception e){
				this.escreverArquivo(jogada);
				this.escreverArquivo("JOGO>"+e.getMessage());
			}
		}
		this.escritor.close();
	}
}
