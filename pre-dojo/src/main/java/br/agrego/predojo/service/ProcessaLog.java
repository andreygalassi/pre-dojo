package br.agrego.predojo.service;

import java.io.InputStream;
import java.util.Scanner;

import br.agrego.predojo.model.Partida;

/**
 * Destinado ao processamento do arquivo de log.
 * @author Andrey Galassi
 *
 */
public class ProcessaLog {

	private final Partida	partida;

	public ProcessaLog(InputStream imputStream) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(imputStream)
        	.useDelimiter("\\r\\n|\\n|$");
		
		partida = new Partida();

		while (sc.hasNext()) {
			String registro = sc.next();
			if (registro!=null) {
				
				if (registro.contains("has started")) {
					new ProcessaInicioPartida().processar(partida, registro);
				}else if(registro.contains("has ended")) {
					new ProcessaFimPartida().processar(partida, registro);
				}else if(registro.contains("<WORLD>")) {
					new ProcessaMundoAssassinando().processar(partida, registro);
				}else if(registro.contains("killed")) {
					new ProcessaJogadorAssassinando().processar(partida, registro);
				}else if(registro.contains("using")) {
					
				}
			}
		}
		
	}

	public Partida getPartida() {
		return partida;
	}
	
}
