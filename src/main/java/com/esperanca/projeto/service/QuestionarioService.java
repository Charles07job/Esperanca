package com.esperanca.projeto.service;

import com.esperanca.projeto.model.Cliente;
import com.esperanca.projeto.model.Questionario;
import com.esperanca.projeto.model.Status;
import com.esperanca.projeto.repository.QuestionarioRepository;
import com.esperanca.projeto.repository.filter.ClienteFilter;
import com.esperanca.projeto.repository.filter.QuestionarioFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionarioService {
    @Autowired
    private QuestionarioRepository repository;

    public void salvar(Questionario questionario){
        calculaMedia(questionario);
        verificaStatus(questionario);
        calculaTotalPontos(questionario);

        repository.save(questionario);
    }
   public void excluir(Questionario questionario) {
       repository.delete(questionario);
    }

	public List<Questionario> filtrar(QuestionarioFilter filtro) {
        if(filtro.getId() == null){
            return repository.findAll();
        }else{
            return (List<Questionario>) repository.findById(filtro.getId()).get();
        }
    }

    private void calculaTotalPontos(Questionario questionario){
        if(questionario!= null){
            questionario.setTotal(somaPontos(questionario));
        }else{
            questionario.setTotal(0.0);
        }
    }

    private void calculaMedia(Questionario questionario){
        if(questionario != null){
            questionario.setMedia(somaPontos(questionario)/5);
        }else{
            questionario.setMedia(0.0);
        }
    }

    private Double somaPontos(Questionario questionario){
        return questionario != null ? (questionario.getColetaSeletiva()+questionario.getCampanhaContraPoluicao()+questionario.getCampanhaReflorestamento()+questionario.getConsumoDeAgua()+questionario.getUtilizaSacolaPlastica()):5.0;
    }

    private void verificaStatus(Questionario questionario){
        if(questionario != null){
            if(questionario.getMedia() >= 5){
                questionario.setStatus(Status.APROVADO);
            }else{
                questionario.setStatus(Status.REPROVADO);
            }
        }
    }

}