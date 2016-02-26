package br.agrego.predojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import br.agrego.predojo.model.Partida;
import br.agrego.predojo.service.ProcessaLog;

public class Main {

	public static void main(String[] args) {
		
		try {
			File file = new File(args[0]);
			InputStream in;
			in = new FileInputStream(file);
			Partida partida = new ProcessaLog(in).getPartida();
			
			partida.imprimeRank();
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao ler o arquivo.");
		}
		
	}

}
