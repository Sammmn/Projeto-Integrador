package com.pi.pizinho.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoEntityRepository extends JpaRepository<PedidoEntity, Integer>{
    
}
