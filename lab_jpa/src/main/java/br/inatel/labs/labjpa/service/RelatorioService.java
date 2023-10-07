package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.dto.TotalCompradoPeloFornecedor;
import br.inatel.labs.labjpa.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository repository;


    public List<TotalCompradoPeloFornecedor> pesquisarTotalCompradoPorFornecedor(){
        return repository.pesquisarTotalcompradoPorFornecedor();
    }
}
