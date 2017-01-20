package br.com.pacote.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pacote.exception.NotFoundException;
import br.com.pacote.modelo.Produto;

@Service
public class ProdutoServico {

	private List<Produto> produtos = new ArrayList<>();

	public List<Produto> findAll() {
		return this.produtos;
	}

	public Produto findBySky(final Long sku) {
		Optional<Produto> prod = this.find(sku);

		if (prod.isPresent())
			return prod.get();
		
		throw new NotFoundException("Sku não foi encontrado");
	}

	public void create(final Produto produto) {
		if (this.isExisteProduto(produto.getSku()))
			throw new RuntimeException("Produto já existe com o sku enviado");
		
		this.produtos.add(produto);
	}

	public void update(Long sku, Produto produto) {
		Optional<Produto> prod = find(sku);

		if (!prod.isPresent())
			throw new NotFoundException("Sku não foi encontrado");

		final int index = this.produtos.indexOf(prod.get());
		this.produtos.add(index, produto);
	}

	public void delete(final Long sku) {
		if (!this.isExisteProduto(sku))
			throw new NotFoundException("Sku não foi encontrado");

		this.produtos.removeIf(s -> s.getSku().equals(sku));
	}

	private Optional<Produto> find(final Long sku) {
		return this.produtos.stream().filter(s -> s.getSku().equals(sku)).findFirst();
	}

	private boolean isExisteProduto(final Long sku) {
		return this.produtos.stream().filter(s -> s.getSku().equals(sku)).findFirst().isPresent();
	}
}
