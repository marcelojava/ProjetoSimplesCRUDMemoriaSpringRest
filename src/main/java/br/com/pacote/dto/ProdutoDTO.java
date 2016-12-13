package br.com.pacote.dto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDTO {

	private Long sku;
	private String nome;
	private String descricao;
	private String ean;
	private DimensaoDTO dimensao;
	private List<String> imagens = new ArrayList<>();

	public ProdutoDTO() {
	}

	public ProdutoDTO(Long sku, String nome, String descricao, String ean, DimensaoDTO dimensao, List<String> imagens) {
		this.sku = sku;
		this.nome = nome;
		this.descricao = descricao;
		this.ean = ean;
		this.dimensao = dimensao;
		this.imagens = imagens;
	}

	public Long getSku() {
		return sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public DimensaoDTO getDimensao() {
		return dimensao;
	}

	public void setDimensao(DimensaoDTO dimensao) {
		this.dimensao = dimensao;
	}

	public List<String> getImagens() {
		return imagens;
	}

	public void setImagens(List<String> imagens) {
		this.imagens = imagens;
	}

}
