package com.esperanca.projeto.service;

import com.esperanca.projeto.model.Cliente;
import com.esperanca.projeto.repository.ClienteRepository;
import com.esperanca.projeto.repository.filter.ClienteFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public void salvar(Cliente cliente) {
        repository.save(cliente);
    }

    public void excluir(Cliente cliente) {
        repository.delete(cliente);
    }

    public List<Cliente> filtrar(ClienteFilter filtro) {
        if(filtro.getCpf() == null) {
        	return repository.findAll();
        }else {
        	return repository.findByCpfContaining(filtro.getCpf());
        }
    }

}