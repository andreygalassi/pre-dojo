package br.agrego.predojo.service;

import br.agrego.predojo.model.Jogador;
import br.agrego.predojo.model.Partida;
import br.agrego.predojo.model.Placar;
import br.agrego.predojo.util.TradutorUtil;

public class ProcessaJogadorAssassinando implements IProcessa {

	private IProcessa	processa;

	@Override
	public void processar(Partida partida, String registro) {
		if(registro.contains("killed")) {
			
			Jogador jAssassino = TradutorUtil.getJogadorAssassino(registro);
			Jogador jMorto = TradutorUtil.getJogadorMorto(registro);
//		Arma arma = TradutorUtil.getArma(registro);
			
			Placar pAssassino = new Placar(jAssassino);
			if (partida.getRank().containsKey(jAssassino)) {
				pAssassino = partida.getRank().get(jAssassino);
			}else {
				partida.getRank().put(jAssassino, pAssassino);
			}
			pAssassino.incrementaAssassinatos();
			
			Placar pMorto = new Placar(jMorto);
			if (partida.getRank().containsKey(jMorto)) {
				pMorto = partida.getRank().get(jMorto);
			}else {
				partida.getRank().put(jMorto, pMorto);
			}
			pMorto.incrementaMorte();
		}else {
			processa.processar(partida, registro);
		}
	}

	@Override
	public void setProximo(IProcessa processa) {
		this.processa = processa;
		// TODO Auto-generated method stub
		
	}

}
