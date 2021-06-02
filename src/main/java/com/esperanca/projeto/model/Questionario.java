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
    private Integer garrafaPet;
    private boolean coletaSeletiva;
    private boolean campanhaAmbiental;
    private boolean campanhaContraPoluicao;
    private boolean campanhaReflorestamento;
    private boolean doacaoEmProlMeioAmbiente;
    private boolean utilizaSacolaPlastica;
    private boolean equipamentoSeloEnergia;
    private boolean consumoDeAgua;
    private boolean alimentosAgro;
    private boolean taxaLimpezaRios;
    private boolean utilizaCaneca;
    private boolean talheresPlasticos;
    private boolean canudosPlaticos;
    private boolean energiaAlternativa;
    private boolean caronaSolidaria;
    @OneToOne
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGarrafaPet() {
        return garrafaPet;
    }

    public void setGarrafaPet(Integer garrafaPet) {
        this.garrafaPet = garrafaPet;
    }

    public boolean isColetaSeletiva() {
        return coletaSeletiva;
    }

    public void setColetaSeletiva(boolean coletaSeletiva) {
        this.coletaSeletiva = coletaSeletiva;
    }

    public boolean isCampanhaAmbiental() {
        return campanhaAmbiental;
    }

    public void setCampanhaAmbiental(boolean campanhaAmbiental) {
        this.campanhaAmbiental = campanhaAmbiental;
    }

    public boolean isCampanhaContraPoluicao() {
        return campanhaContraPoluicao;
    }

    public void setCampanhaContraPoluicao(boolean campanhaContraPoluicao) {
        this.campanhaContraPoluicao = campanhaContraPoluicao;
    }

    public boolean isCampanhaReflorestamento() {
        return campanhaReflorestamento;
    }

    public void setCampanhaReflorestamento(boolean campanhaReflorestamento) {
        this.campanhaReflorestamento = campanhaReflorestamento;
    }

    public boolean isDoacaoEmProlMeioAmbiente() {
        return doacaoEmProlMeioAmbiente;
    }

    public void setDoacaoEmProlMeioAmbiente(boolean doacaoEmProlMeioAmbiente) {
        this.doacaoEmProlMeioAmbiente = doacaoEmProlMeioAmbiente;
    }

    public boolean isUtilizaSacolaPlastica() {
        return utilizaSacolaPlastica;
    }

    public void setUtilizaSacolaPlastica(boolean utilizaSacolaPlastica) {
        this.utilizaSacolaPlastica = utilizaSacolaPlastica;
    }

    public boolean isEquipamentoSeloEnergia() {
        return equipamentoSeloEnergia;
    }

    public void setEquipamentoSeloEnergia(boolean equipamentoSeloEnergia) {
        this.equipamentoSeloEnergia = equipamentoSeloEnergia;
    }

    public boolean isConsumoDeAgua() {
        return consumoDeAgua;
    }

    public void setConsumoDeAgua(boolean consumoDeAgua) {
        this.consumoDeAgua = consumoDeAgua;
    }

    public boolean isAlimentosAgro() {
        return alimentosAgro;
    }

    public void setAlimentosAgro(boolean alimentosAgro) {
        this.alimentosAgro = alimentosAgro;
    }

    public boolean isTaxaLimpezaRios() {
        return taxaLimpezaRios;
    }

    public void setTaxaLimpezaRios(boolean taxaLimpezaRios) {
        this.taxaLimpezaRios = taxaLimpezaRios;
    }

    public boolean isUtilizaCaneca() {
        return utilizaCaneca;
    }

    public void setUtilizaCaneca(boolean utilizaCaneca) {
        this.utilizaCaneca = utilizaCaneca;
    }

    public boolean isTalheresPlasticos() {
        return talheresPlasticos;
    }

    public void setTalheresPlasticos(boolean talheresPlasticos) {
        this.talheresPlasticos = talheresPlasticos;
    }

    public boolean isCanudosPlaticos() {
        return canudosPlaticos;
    }

    public void setCanudosPlaticos(boolean canudosPlaticos) {
        this.canudosPlaticos = canudosPlaticos;
    }

    public boolean isEnergiaAlternativa() {
        return energiaAlternativa;
    }

    public void setEnergiaAlternativa(boolean energiaAlternativa) {
        this.energiaAlternativa = energiaAlternativa;
    }

    public boolean isCaronaSolidaria() {
        return caronaSolidaria;
    }

    public void setCaronaSolidaria(boolean caronaSolidaria) {
        this.caronaSolidaria = caronaSolidaria;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
}
