package com.pi.pizinho.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "pizza")
public class PizzaEntity {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message="Nome da pizza obrigatório")
    private String nome;
    @NotBlank(message="Sabor da pizza obrigatório")
    private String sabor;
    @NotNull(message="Preço da pizza obrigatório")
    private float preco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
}
