package com.pi.pizinho.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedido")
public class PedidoEntity {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message="Nome do cliente obrigatório") 
    private String cliente;
    @NotBlank(message="Endereço do cliente obrigatório") 
    private String endereco;
    @NotBlank(message="Telefone do cliente obrigatório") 
    private String telefone;
    @NotBlank(message="CPF do cliente obrigatório") 
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "pizza_id", referencedColumnName = "id")
    private PizzaEntity pizza;
    @NotNull(message="Quantidade obrigatório") 
    private int quantidade;
    @NotNull(message="Preço obrigatório") 
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

    public PizzaEntity getPizza() {
        return pizza; 
    }
    
    public void setPizza(PizzaEntity pizza) {
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
