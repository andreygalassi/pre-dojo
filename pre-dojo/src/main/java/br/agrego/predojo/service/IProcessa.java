package br.agrego.predojo.service;

import br.agrego.predojo.model.Partida;

public interface IProcessa {

	public void processar(Partida partida, String registro);
	public void setProximo(IProcessa processa);
}
