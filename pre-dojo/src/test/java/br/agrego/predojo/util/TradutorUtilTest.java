package br.agrego.predojo.util;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.agrego.predojo.model.Jogador;

public class TradutorUtilTest {

	private final static String LOG1 = "23/04/2013 15:34:22 - New match 11348965 has started";
	private final static String LOG2 = "23/04/2013 15:36:04 - Roman killed Nick using M16";
	private final static String LOG3 = "23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN";
	private final static String LOG4 = "23/04/2013 15:39:22 - Match 11348965 has ended";
	
	
	@Test
	public void deveIdentificarAData() {
		Date data = TradutorUtil.getData(LOG1);
		Calendar gc = GregorianCalendar.getInstance();
		gc.set(2013, 3, 23, 15, 34, 22);
		
		assertEquals(gc.getTime().toString(), data.toString());
	}
	
	@Test
	public void deveIdentificarOCodigoDaPartida() {
		String codigo = TradutorUtil.getCodigoPartida(LOG1);
		
		assertEquals("11348965", codigo);
	}
	
	@Test
	public void deveIdentificarOAssassino() {
		Jogador assassino = TradutorUtil.getJogadorAssassino(LOG2);
		Jogador jEsperado = new Jogador("Roman");
		assertEquals(jEsperado, assassino);
	}
	
	@Test
	public void deveIdentificarOMorto() {
		Jogador morto = TradutorUtil.getJogadorMorto(LOG2);
		Jogador jEsperado = new Jogador("Nick");
		assertEquals(jEsperado, morto);
	}
	
	@Test
	public void deveIdentificarMortoPeloMundo() {
		Jogador morto = TradutorUtil.getJogadorMortoPeloMundo(LOG3);
		Jogador jEsperado = new Jogador("Nick");
		assertEquals(jEsperado, morto);
	}
	
	@Test
	public void deveIdentificarFimDaPartida() {
		Boolean fim = TradutorUtil.getFimDaPartida(LOG4);
		Assert.assertTrue(fim);
	}
}
