package br.agrego.predojo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.agrego.predojo.model.Arma;
import br.agrego.predojo.model.Jogador;

/**
 * Classe utilitária destinada a traduzir cada linha do log e criar os devidos objetos
 * @author Andrey Galassi
 *
 */
public class TradutorUtil {
	
	private TradutorUtil() {
		// TODO Auto-generated constructor stub
	}
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static Date getData(String registro) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(registro).useDelimiter(" - ");
		Date time = null;
		try {
			time = sdf.parse(sc.next());
		} catch (ParseException e) {
			System.out.println("Erro ao ler a data do log: " + registro);
		}
		return time;
	}
	public static String getCodigoPartida(String registro) {
		String dado = registro.split(" - ")[1];
		dado = dado.replace("New match", "");
		dado = dado.replace("has started", "");
		return dado.trim();
	}
	public static Jogador getJogadorMortoPeloMundo(String registro) {
		String dado = registro.split(" - ")[1];
		dado = dado.replace("<WORLD> killed", "");
		dado = dado.substring(0, dado.indexOf("by"));
		
		return new Jogador(dado.trim());
	}
	public static Jogador getJogadorAssassino(String registro) {
		String dado = registro.split(" - ")[1];
		dado = dado.substring(0, dado.indexOf("killed"));

		return new Jogador(dado.trim());
	}
	public static Jogador getJogadorMorto(String registro) {
		String dado = registro.split(" - ")[1];
		dado = dado.substring(dado.indexOf("killed")+"killed".length(), dado.indexOf("using"));

		return new Jogador(dado.trim());
	}
	public static Arma getArma(String registro) {
		String dado = registro.split(" - ")[1];
		dado = dado.substring(dado.indexOf("using")+"using".length());
		
		return new Arma(dado.trim());
	}
	public static Boolean getFimDaPartida(String registro) {
		String dado = registro.split(" - ")[1];
		return dado.contains("has ended");
	}
}
