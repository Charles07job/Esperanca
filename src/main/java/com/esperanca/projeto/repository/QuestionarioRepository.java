package com.esperanca.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esperanca.projeto.model.Questionario;

@Repository
public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {
}
