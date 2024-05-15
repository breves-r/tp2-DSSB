package com.infnet.tp2.service;

import com.infnet.tp2.model.Produto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();

    public ProdutoService() {
        produtos.addAll(List.of(
                new Produto(1, "Celular", 3000.0, "Eletrônico"),
                new Produto(2, "Notebook", 7000.0, "Eletrônico"),
                new Produto(3, "Camiseta", 80.0, "Vestuário")

        ));
    }

    public List<Produto> getAll() {
        return this.produtos;
    }

    public Produto getById(int id) {
        return this.findProduto(id);
    }

    public Produto save(Produto produto) {
        produtos.add(produto);
        return produto;
    }

    public Produto update(Integer id, Produto newProduto) {
        Produto produto = this.findProduto(id);
        int produtoIdx = produtos.indexOf(produto);
        produtos.set(produtoIdx, newProduto);
        return newProduto;
    }

    public void deleteById(Integer id) {
        Produto produto = this.findProduto(id);
        produtos.remove(produto);
    }

    private Produto findProduto(int id) {
        Optional<Produto> produto = produtos.stream().filter(prod -> prod.getId() == id).findFirst();
        if(produto.isEmpty()) throw new EntityNotFoundException("Produto não encontrado");
        return produto.get();
    }
}
