package br.inatel.labs.labrest.server.controller;

import br.inatel.labs.labrest.server.model.Produto;
import br.inatel.labs.labrest.server.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<Produto> getProdutos(){
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable("id") Long produtoId){
        Optional<Produto> optionalProduto = produtoService.findById(produtoId);

        if(optionalProduto.isEmpty()){
            String msgErro = String.format("Nenhum produto encontrado com id [%s]", produtoId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgErro);
        }

        return optionalProduto.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto postProduto(@RequestBody Produto p){
        Produto produtoCriado = produtoService.create(p);
        return produtoCriado;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putProduto(@RequestBody Produto p){
        produtoService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduto(@PathVariable("id") Long id){
        Produto produtoEncontrado = this.getProdutoById(id);
        produtoService.remove(produtoEncontrado);
    }
}
