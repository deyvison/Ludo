package ufpb.aps.ludo.modelo;

public class Casa {
	
	
	private String id;
	private String acao;
	private String idProximaCasa;
	
	public Casa(String id, String acao, String idProximaCasa){
		this.id = id;
		this.acao = acao;
		this.idProximaCasa = idProximaCasa;
	}
	
	public String getID(){
		return this.id;
	}
	
	public String getAcao(){
		return this.acao;
	}
	
	public String getIDProximaCasa(){
		return this.idProximaCasa;
	}
}
