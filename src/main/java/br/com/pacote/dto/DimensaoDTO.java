package br.com.pacote.dto;

import br.com.pacote.modelo.Dimensao;

public class DimensaoDTO {

	private double peso;
	private double altura;
	private double largura;
	private double tamanho;

	public DimensaoDTO() {
	}

	public DimensaoDTO(Dimensao dimensao) {
		this.peso = dimensao.getPeso();
		this.altura = dimensao.getAltura();
		this.largura = dimensao.getLargura();
		this.tamanho = dimensao.getTamanho();
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
}
