package br.agrego.predojo.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class TimeLine {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private final Date time;
	private final String ocorrencia;
	
	public TimeLine(String linhaLog) throws Exception {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(linhaLog) .useDelimiter(" - ");
		try {
			time = sdf.parse(sc.next());
		} catch (ParseException e) {
			throw new Exception("Erro ao ler a data do log: " + linhaLog);
		}
		ocorrencia = sc.next();
	}
	
	public abstract void processa();

	public Date getTime() {
		return time;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}
	
}
