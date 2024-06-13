package com.pi.pizinho.service;

import com.pi.pizinho.data.PizzaEntity;
import com.pi.pizinho.data.PizzaEntityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    
    @Autowired
    
    PizzaEntityRepository pzer;
    
    public void cadastraPizza(PizzaEntity pizza){
        pizza.setId(null);
        pzer.save(pizza);
    }
    
    public void deletarPizza(Integer id){
        pzer.deleteById(id);
    }
    
    public PizzaEntity atualizarPizza(int id,PizzaEntity pizza){
        PizzaEntity p = getPizzaById(id);
        if(p != null){
            p.setNome(pizza.getNome());
            p.setPreco(pizza.getPreco());
            p.setSabor(pizza.getSabor());
            return pzer.save(p);
        }
        return null;
    }
    
    public List<PizzaEntity> getPizzas(){
        return pzer.findAll();
    }
    
    public PizzaEntity getPizzaById(int id){
        return pzer.findById(id).orElse(null);
    }
}
