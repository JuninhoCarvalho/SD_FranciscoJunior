package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.DTO.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

public class WebClientGetMonoProdutoPeloId {

    public static void main(String[] args){

        Mono<ProdutoDTO> monoProduto = WebClient.create(Constantes.BASE_URL)
                .get()
                .uri("/produto/1")
                .retrieve()
                .bodyToMono(ProdutoDTO.class);

        monoProduto.subscribe();

        ProdutoDTO produto = monoProduto.block();

        System.out.println("Produto encontrado");
        System.out.println(produto);
    }
}
