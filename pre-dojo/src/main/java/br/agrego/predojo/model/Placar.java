package br.agrego.predojo.model;

/**
 * Placar de cada um jogador
 * Informa a quantidade de assassinatos e mortes do jogador
 * @author Andrey Galassi
 *
 */
public class Placar {

	private Jogador jogador;
	private int mortes;
	private int assassinatos;
	
	public Placar(Jogador jogador) {
		this.jogador = jogador;
	}
	public int getMortes() {
		return mortes;
	}
	public void setMortes(int mortes) {
		this.mortes = mortes;
	}
	public int getAssassinatos() {
		return assassinatos;
	}
	public void setAssassinatos(int assassinatos) {
		this.assassinatos = assassinatos;
	}
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	public void incrementaMorte() {
		mortes++;
	}
	public void incrementaAssassinatos() {
		assassinatos++;
	}
	
	@Override
	public String toString() {
		return String.format("Jogador %10s: Assassinatos: %-5s Mortes: %-5s ", jogador.getNome(),assassinatos,mortes);
	}
	
}
