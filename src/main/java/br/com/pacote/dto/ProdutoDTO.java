package br.com.pacote.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.pacote.modelo.Produto;

public class ProdutoDTO {

	private Long sku;
	private String nome;
	private String descricao;
	private String ean;
	private DimensaoDTO dimensao;
	private List<String> imagens = new ArrayList<>();

	public ProdutoDTO() {
	}

	public ProdutoDTO(Produto produto) {
		this.sku = produto.getSku();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.ean = produto.getEan();
		this.dimensao = new DimensaoDTO(produto.getDimensao());
		this.imagens = produto.getImagens();
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
