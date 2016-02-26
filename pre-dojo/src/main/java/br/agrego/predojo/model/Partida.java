package br.agrego.predojo.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Especifica uma partida, cada log processado gera uma partida com inicio, fim e o rank dos jogadores
 * @author Andrey Galassi
 *
 */
public class Partida {

	private String codigo;
	private Date dtInicio;
	private Date dtFim;
	private final Map<Jogador, Placar> rank;
	
	public Partida() {
		this.rank = new HashMap<Jogador, Placar>();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	public Date getDtFim() {
		return dtFim;
	}
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Map<Jogador, Placar> getRank() {
		return rank;
	}
}
