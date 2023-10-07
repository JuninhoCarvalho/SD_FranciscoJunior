package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.entity.Endereco;
import br.inatel.labs.labjpa.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco salvar(Endereco e){
        return repository.save(e);
    }
}
