package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.dto.TotalCompradoPeloFornecedor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class RelatorioServiceTeste {

    @Autowired
    private RelatorioService service;

    @Test
    void test(){
        List<TotalCompradoPeloFornecedor> listDto = service.pesquisarTotalCompradoPorFornecedor();

        assertFalse(listDto.isEmpty());

        System.out.println("FornecedorRazaoSocial : TotalComprado");
        listDto.forEach(r -> {
            System.out.println( r.fornecedorRazaoSocial() + " : " + r.totalComprado());
        });
    }
}
