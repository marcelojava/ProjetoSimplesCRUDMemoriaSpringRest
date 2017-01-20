package br.com.pacote.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pacote.dto.ProdutoDTO;
import br.com.pacote.modelo.Produto;
import br.com.pacote.servico.ProdutoServico;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoServico produtoService;

	@RequestMapping(value = "/produtos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<Produto> produtos = this.produtoService.findAll();
		
		if (produtos.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<ProdutoDTO> produtosDtos = produtos.stream().map(ProdutoDTO::new).collect(toList());
		return new ResponseEntity<>(produtosDtos, HttpStatus.OK);
	}

	@RequestMapping(value = "/produtos/{sku}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProdutoDTO> findBySku(@PathVariable(name = "sku") Long sku) {
		Produto produto = produtoService.findBySky(sku);
		ProdutoDTO produtoDTO = new ProdutoDTO(produto);
		return new ResponseEntity<>(produtoDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/produtos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> create(@RequestBody Produto produto) {
		this.produtoService.create(produto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/produtos/{sku}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> update(@PathVariable("sku") Long sku, @RequestBody Produto produto) {
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/produtos/{sku}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("sku") Long sku) {
		this.produtoService.delete(sku);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
