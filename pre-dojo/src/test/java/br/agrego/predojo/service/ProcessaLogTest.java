package br.agrego.predojo.service;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import br.agrego.predojo.model.Jogador;
import br.agrego.predojo.model.Partida;

public class ProcessaLogTest {

	private Partida	partida;

	@Before
	public void before() {
		InputStream in = getClass().getClassLoader().getResourceAsStream("teste.log");
		
		ProcessaLog processaLog = new ProcessaLog(in);
		
		partida = processaLog.getPartida();
	}
	
	@Test
	public void deveProcessarLogCriandoPartida() {
		Calendar gcInicio = GregorianCalendar.getInstance();
		gcInicio.set(2013, 3, 23, 15, 34, 22);
		Calendar gcFim = GregorianCalendar.getInstance();
		gcFim.set(2013, 3, 23, 15, 39, 22);

		assertEquals(gcInicio.getTime().toString(), partida.getDtInicio().toString());
		assertEquals(gcFim.getTime().toString(), partida.getDtFim().toString());
		
		assertEquals("11348965", partida.getCodigo());
		
		assertEquals(2, partida.getRank().size());
	}
	
	@Test
	public void deveIdentificarOPlacarAposProcessamento() {
		
		Jogador jogadorRoman = new Jogador("Roman");
		Jogador jogadorNick = new Jogador("Nick");
		
		assertEquals(1, partida.getRank().get(jogadorRoman).getAssassinatos());
		assertEquals(0, partida.getRank().get(jogadorRoman).getMortes());
		
		assertEquals(0, partida.getRank().get(jogadorNick).getAssassinatos());
		assertEquals(2, partida.getRank().get(jogadorNick).getMortes());
		
	}
}
