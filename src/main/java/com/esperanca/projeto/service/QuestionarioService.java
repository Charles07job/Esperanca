package com.esperanca.projeto.service;

import com.esperanca.projeto.model.Questionario;
import com.esperanca.projeto.repository.QuestionarioRepository;
import com.esperanca.projeto.repository.filter.QuestionarioFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionarioService {
    @Autowired
    private QuestionarioRepository repository;

    public void salvar(Questionario questionario){
        repository.save(questionario);
    }
   public void excluir(Questionario questionario) {
       repository.delete(questionario);
    }

    @SuppressWarnings("unchecked")
	public List<Questionario> filtrar(QuestionarioFilter filtro) {
        return (List<Questionario>) repository.findById(filtro.getId()).get();
    }

}