package br.agrego.predojo.aplicacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import br.agrego.predojo.model.Partida;
import br.agrego.predojo.service.ProcessaLog;

public class Main {

	public static void main(String[] args) {
		if (args==null || args.length==0) {
			System.out.println("Informa o arquivo de log como parametro.");
		}else {
		
			try {
				
				File file = new File(args[0]);
				InputStream in;
				in = new FileInputStream(file);
				Partida partida = new ProcessaLog(in).getPartida();
				
				System.out.println(partida.imprimeRank());
				
			} catch (FileNotFoundException e) {
				System.out.println("Arquivo não encontrado.");
			}
		}
	}

}
