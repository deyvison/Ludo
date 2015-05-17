package ufpb.aps.ludo.io;


public class Main {
	
	public static void main(String[] args) throws Exception {
	
		LudoIO io = new LudoIO(args[0],args[1]);

		io.iniciarJogo();
	}
}
