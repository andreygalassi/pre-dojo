package br.agrego.predojo.service;

import br.agrego.predojo.model.Partida;
import br.agrego.predojo.util.TradutorUtil;

public class ProcessaInicioPartida implements IProcessa {

	private IProcessa	processa;

	@Override
	public void processar(Partida partida, String registro) {
		if (registro.contains("has started")) {
			
			partida.setCodigo(TradutorUtil.getCodigoPartida(registro));
			partida.setDtInicio(TradutorUtil.getData(registro));
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
