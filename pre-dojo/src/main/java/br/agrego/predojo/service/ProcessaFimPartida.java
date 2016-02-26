package br.agrego.predojo.service;

import br.agrego.predojo.model.Partida;
import br.agrego.predojo.util.TradutorUtil;

public class ProcessaFimPartida implements IProcessa {

	@Override
	public void processar(Partida partida, String registro) {
		partida.setDtFim(TradutorUtil.getData(registro));
	}
	

}
