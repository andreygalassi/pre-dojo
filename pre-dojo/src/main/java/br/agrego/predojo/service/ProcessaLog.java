package br.agrego.predojo.service;

import java.io.InputStream;
import java.util.Scanner;

import br.agrego.predojo.model.Jogador;
import br.agrego.predojo.model.Partida;
import br.agrego.predojo.model.Placar;
import br.agrego.predojo.util.TradutorUtil;

/**
 * Destinado ao processamento do arquivo de log.
 * @author Andrey Galassi
 *
 */
public class ProcessaLog {

	private final Partida	partida;

	public ProcessaLog(InputStream imputStream) {
//		InputStream in = getClass().getClassLoader().getResourceAsStream(arquivo);
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(imputStream)
        	.useDelimiter("\\r\\n|\\n|$");
		
		partida = new Partida();

		while (sc.hasNext()) {
			String registro = sc.next();
			if (registro!=null) {
				
				if (registro.contains("has started")) {
					partida.setCodigo(TradutorUtil.getCodigoPartida(registro));
					partida.setDtInicio(TradutorUtil.getData(registro));
				}else if(registro.contains("has ended")) {
					partida.setDtFim(TradutorUtil.getData(registro));
				}else if(registro.contains("<WORLD>")) {
					Jogador jMorto = TradutorUtil.getJogadorMortoPeloMundo(registro);
					
					Placar placar = new Placar();
					if (partida.getRank().containsKey(jMorto)) {
						placar = partida.getRank().get(jMorto);
					}else {
						partida.getRank().put(jMorto, placar);
					}
					
					placar.incrementaMorte();
					
				}else if(registro.contains("killed")) {
					Jogador jAssassino = TradutorUtil.getJogadorAssassino(registro);
					Jogador jMorto = TradutorUtil.getJogadorMorto(registro);
//					Arma arma = TradutorUtil.getArma(registro);
					
					Placar pAssassino = new Placar();
					if (partida.getRank().containsKey(jAssassino)) {
						pAssassino = partida.getRank().get(jAssassino);
					}else {
						partida.getRank().put(jAssassino, pAssassino);
					}
					pAssassino.incrementaAssassinatos();
					
					Placar pMorto = new Placar();
					if (partida.getRank().containsKey(jMorto)) {
						pMorto = partida.getRank().get(jMorto);
					}else {
						partida.getRank().put(jMorto, pMorto);
					}
					pMorto.incrementaMorte();
					
				}else if(registro.contains("using")) {
					
				}
			}
		}
		
	}

	public Partida getPartida() {
		return partida;
	}
	
}
