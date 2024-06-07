package com.pi.pizinho.model;

public class Pedido {

    private Integer id;
    private String cliente;
    private String endereco;
    private String telefone;
    private String cpf;
    private Pizza pizza;
    private int quantidade;
    private float precoTotal;


    public Integer getId() {
        return id; 
    }
    
    public void setId(Integer id) {
        this.id = id; 
    }

    public String getCliente() {
        return cliente; 
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente; 
    }

    public String getEndereco() {
        return endereco; 
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco; 
    }

    public String getTelefone() {
        return telefone; 
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone; 
    }

    public String getCpf() {
        return cpf; 
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf; 
    }

    public Pizza getPizza() {
        return pizza; 
    }
    
    public void setPizza(Pizza pizza) {
        this.pizza = pizza; 
    }

    public int getQuantidade() {
        return quantidade; 
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade; 
    }

    public float getPrecoTotal() {
        return precoTotal; 
    }
    
    public void setPrecoTotal(float precoTotal) { 
        this.precoTotal = precoTotal; 
    }

    public void calcularPrecoTotal() {
        this.precoTotal = this.pizza.getPreco() * this.quantidade;
    }
}
