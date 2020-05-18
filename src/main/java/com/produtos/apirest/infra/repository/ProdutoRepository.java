package com.produtos.apirest.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.impl.business.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto findById(long id);
}
