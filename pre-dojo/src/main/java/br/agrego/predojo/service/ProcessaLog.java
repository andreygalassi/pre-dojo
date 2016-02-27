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
		partida = new Partida();
		processarArquivo(imputStream);
		
	}

	private void processarArquivo(InputStream imputStream) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(imputStream)
        	.useDelimiter("\\r\\n|\\n|$");

		IProcessa p1 = new ProcessaInicioPartida();
		IProcessa p2 = new ProcessaFimPartida();
		IProcessa p3 = new ProcessaMundoAssassinando();
		IProcessa p4 = new ProcessaJogadorAssassinando();
		IProcessa p5 = new ProcessaSemProcessamento();
		
		p1.setProximo(p2);
		p2.setProximo(p3);
		p3.setProximo(p4);
		p4.setProximo(p5);
		
		while (sc.hasNext()) {
			String registro = sc.next();
			if (registro!=null) {
				
				p1.processar(partida, registro);

			}
		}
	}

	public Partida getPartida() {
		return partida;
	}
	
}
