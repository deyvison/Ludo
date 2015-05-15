package ufpb.aps.ludo.facade;

import java.util.ArrayList;

import ufpb.aps.ludo.io.LudoIO;
import ufpb.aps.ludo.modelo.Ludo;

public class LudoFacade {
	
	private LudoIO io;
	private Ludo ludo;
	
	public LudoFacade(String arquivoEntrada, String arquivoSaida) throws Exception{
		
		this.io = new LudoIO(arquivoEntrada, arquivoSaida);
		this.ludo = new Ludo(io.lerArquivo());
	}
	
	public void jogar() {
		
	}
	
	
}
