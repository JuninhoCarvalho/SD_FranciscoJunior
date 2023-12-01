package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.DTO.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

public class WebClientGetFluxProduto {

    public static void main(String[] args){

        ArrayList<ProdutoDTO> listaProduto = new ArrayList<ProdutoDTO>();

        Flux<ProdutoDTO> fluxProduto = WebClient.create(Constantes.BASE_URL)
                .get()
                .uri("/produto")
                .retrieve()
                .bodyToFlux(ProdutoDTO.class);

        fluxProduto.subscribe(p -> listaProduto.add(p));

        fluxProduto.blockLast();

        System.out.println("Lista de produtos");
        System.out.println(listaProduto);
    }
}
