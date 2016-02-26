package br.agrego.predojo.service;

import br.agrego.predojo.model.Jogador;
import br.agrego.predojo.model.Partida;
import br.agrego.predojo.model.Placar;
import br.agrego.predojo.util.TradutorUtil;

public class ProcessaMundoAssassinando implements IProcessa {

	private IProcessa	processa;

	@Override
	public void processar(Partida partida, String registro) {
		if(registro.contains("<WORLD>")) {
			
			Jogador jMorto = TradutorUtil.getJogadorMortoPeloMundo(registro);
			
			Placar placar = new Placar(jMorto);
			if (partida.getRank().containsKey(jMorto)) {
				placar = partida.getRank().get(jMorto);
			}else {
				partida.getRank().put(jMorto, placar);
			}
			
			placar.incrementaMorte();
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
