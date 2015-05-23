package ufpb.aps.ludo.modelo;

import ufpb.aps.ludo.enumAcoes.Acao;

public class Casa {
	
	private String id,idProximaCasa;
	private Acao acao;
	
	public Casa(String id, Acao acao, String idProximaCasa){
		this.id = id;
		this.acao = acao;
		this.idProximaCasa = idProximaCasa;
	}
	
	public String getID(){
		return this.id;
	}
	
	public Acao getAcao(){
		return this.acao;
	}
	
	public String getIDProximaCasa(){
		return this.idProximaCasa;
	}
}
