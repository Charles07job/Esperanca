package com.esperanca.projeto.dto;

import com.esperanca.projeto.model.Cliente;

public class RequisicaoNovoFormulario {
	
	private String nomeCliente;
	private String CPFCliente;
	private String escolaCliente;
	private float salarioCliente;
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCPFCliente() {
		return CPFCliente;
	}
	public void setCPFCliente(String cPFCliente) {
		CPFCliente = cPFCliente;
	}
	public String getEscolaCliente() {
		return escolaCliente;
	}
	public void setEscolaCliente(String escolaCliente) {
		this.escolaCliente = escolaCliente;
	}
	public float getSalarioCliente() {
		return salarioCliente;
	}
	public void setSalarioCliente(float salarioCliente) {
		this.salarioCliente = salarioCliente;
	}
	public Cliente toPedido() {
		Cliente cliente = new Cliente();
		cliente.setCpf(CPFCliente);
		cliente.setEscolaridade(escolaCliente);
		cliente.setNome(nomeCliente);
		cliente.setSalario(salarioCliente);
		return cliente;
	}
	
	
	
	
}
