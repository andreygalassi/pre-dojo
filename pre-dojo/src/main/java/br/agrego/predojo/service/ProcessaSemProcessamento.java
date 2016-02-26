package br.agrego.predojo.service;

import br.agrego.predojo.model.Partida;

public class ProcessaSemProcessamento implements IProcessa {

	@Override
	public void processar(Partida partida, String registro) {
		//fim da cadeia
	}

	@Override
	public void setProximo(IProcessa processa) {
		//fim da cadeia
	}

}
