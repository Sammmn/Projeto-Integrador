package com.pi.pizinho.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaEntityRepository extends JpaRepository<PizzaEntity, Integer>{
    
}
