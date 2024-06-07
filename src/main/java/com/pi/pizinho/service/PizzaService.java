package com.pi.pizinho.service;

import com.pi.pizinho.model.Pizza;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    
    private int contador = 1;
    
    private ArrayList<Pizza> listaPizza;

    public PizzaService() {
        this.listaPizza = new ArrayList<>();
    }
    
    public void cadastraPizza(Pizza pizza){
        pizza.setId(contador);
        listaPizza.add(pizza);
        contador++;
    }
    
    public void deletarPizza(Integer id){
        Pizza p = getPizzaById(id);
        listaPizza.remove(p);
    }
    
    public void atualizarPizza(int id,Pizza pizza){
        for(Pizza p: listaPizza){
            if(p.getId() == id){
                p.setNome(pizza.getNome());
                p.setPreco(pizza.getPreco());
                p.setSabor(pizza.getSabor());
            }
        }
    }
    
    public List<Pizza> getPizzas(){
        return this.listaPizza;
    }
    
    public Pizza getPizzaById(int id){
        for(Pizza p: listaPizza){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
}
