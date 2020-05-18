package com.produtos.apirest.api.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.impl.business.Produto;
import com.produtos.apirest.infra.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoRest {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@ApiOperation(value = "Listar Produtos")
	@GetMapping("/produtos")
	public List<Produto> listarProdutos(){
		return produtoRepository.findAll();
	}
	
	@ApiOperation(value = "Listar Produtos por ID")
	@GetMapping("/produtos/{id}")
	public Produto listarProdutoPorID(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@ApiOperation(value = "Cadastrar Produto")
	@PostMapping("/produto")
	public Produto cadastrarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@ApiOperation(value = "Apagar um Produto")
	@DeleteMapping("/produto")
	public void deletarProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@ApiOperation(value = "Atualizar um produto")
	@PutMapping("/produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
