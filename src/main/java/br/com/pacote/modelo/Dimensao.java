package br.com.pacote.modelo;

public class Dimensao {

	private double peso;
	private double altura;
	private double largura;
	private double tamanho;

	public Dimensao() {
	}

	public Dimensao(double peso, double altura, double largura, double tamanho) {
		this.peso = peso;
		this.altura = altura;
		this.largura = largura;
		this.tamanho = tamanho;
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
