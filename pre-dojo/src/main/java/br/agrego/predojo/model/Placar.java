package br.agrego.predojo.model;

public class Placar {

	private Jogador jogador;
	private int mortes;
	private int assassinatos;
	
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
	
}
