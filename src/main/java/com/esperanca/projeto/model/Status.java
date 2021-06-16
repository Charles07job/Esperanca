package com.esperanca.projeto.model;

public enum Status {

    APROVADO("Aprovado"),
    REPROVADO("Reprovado");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}