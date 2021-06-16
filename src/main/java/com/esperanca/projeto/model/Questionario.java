package com.esperanca.projeto.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Questionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double media;
    private Double total;
    private Double coletaSeletiva;
    private Double campanhaContraPoluicao;
    private Double campanhaReflorestamento;
    private Double consumoDeAgua;
    private Double utilizaSacolaPlastica;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getColetaSeletiva() {
        return coletaSeletiva;
    }

    public void setColetaSeletiva(Double coletaSeletiva) {
        this.coletaSeletiva = coletaSeletiva;
    }

    public Double getCampanhaContraPoluicao() {
        return campanhaContraPoluicao;
    }

    public void setCampanhaContraPoluicao(Double campanhaContraPoluicao) {
        this.campanhaContraPoluicao = campanhaContraPoluicao;
    }

    public Double getCampanhaReflorestamento() {
        return campanhaReflorestamento;
    }

    public void setCampanhaReflorestamento(Double campanhaReflorestamento) {
        this.campanhaReflorestamento = campanhaReflorestamento;
    }

    public Double getConsumoDeAgua() {
        return consumoDeAgua;
    }

    public void setConsumoDeAgua(Double consumoDeAgua) {
        this.consumoDeAgua = consumoDeAgua;
    }

    public Double getUtilizaSacolaPlastica() {
        return utilizaSacolaPlastica;
    }

    public void setUtilizaSacolaPlastica(Double utilizaSacolaPlastica) {
        this.utilizaSacolaPlastica = utilizaSacolaPlastica;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isAprovado() {
        return Status.APROVADO.equals(this.status);
    }

    public boolean isReprovado() {
        return Status.REPROVADO.equals(this.status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questionario that = (Questionario) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Questionario{" +
                "id=" + id +
                ", media=" + media +
                ", total=" + total +
                ", coletaSeletiva=" + coletaSeletiva +
                ", campanhaContraPoluicao=" + campanhaContraPoluicao +
                ", campanhaReflorestamento=" + campanhaReflorestamento +
                ", consumoDeAgua=" + consumoDeAgua +
                ", utilizaSacolaPlastica=" + utilizaSacolaPlastica +
                ", cliente=" + cliente.getNome() +
                '}';
    }
}
