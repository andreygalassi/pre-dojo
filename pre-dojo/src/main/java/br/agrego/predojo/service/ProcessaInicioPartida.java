package br.agrego.predojo.service;

import br.agrego.predojo.model.Partida;
import br.agrego.predojo.util.TradutorUtil;

public class ProcessaInicioPartida implements IProcessa {

	@Override
	public void processar(Partida partida, String registro) {
		partida.setCodigo(TradutorUtil.getCodigoPartida(registro));
		partida.setDtInicio(TradutorUtil.getData(registro));
	}

}
