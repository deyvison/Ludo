package ufpb.aps.ludo.enumAcoes;

public enum Acao {
	
	FIM, IR_PARA, NADA, REPETE, PARA, INICIO;
	
	public static Acao atribuirAcao(String s){
		if(s.equals("FIM")){
			return Acao.FIM;
		}else if(s.equals("IR_PARA")){
			return Acao.IR_PARA;
		}else if(s.equals("NADA")){
			return Acao.NADA;
		}else if(s.equals("REPETE")){
			return Acao.REPETE;
		}else if(s.equals("PARA")){
			return Acao.PARA;
		}else if(s.equals("INICIO")){
			return Acao.INICIO;
		}
		return null;
	}
}
