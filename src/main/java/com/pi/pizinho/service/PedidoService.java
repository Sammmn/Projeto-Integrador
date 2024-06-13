package com.pi.pizinho.service;

import com.pi.pizinho.data.PedidoEntity;
import com.pi.pizinho.data.PedidoEntityRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PedidoService {
    
    @Autowired
    
    PedidoEntityRepository per;

    public void cadastraPedido(PedidoEntity pedido) {
        pedido.setId(null);
        pedido.calcularPrecoTotal();  
        per.save(pedido);
    }

    public void deletarPedido(PedidoEntity pedido) {
        per.deleteById(pedido.getId());
    }

    public PedidoEntity atualizarPedido(int id, PedidoEntity pedido) {
        PedidoEntity p = getPedidoById(id);
        if (p != null) {
            p.setCliente(pedido.getCliente());
            p.setCpf(pedido.getCpf());
            p.setEndereco(pedido.getEndereco());
            p.setTelefone(pedido.getTelefone());
            p.setPrecoTotal(pedido.getPrecoTotal());
            p.setPizza(pedido.getPizza());
            p.setQuantidade(pedido.getQuantidade());
            return per.save(p);
        }
        return null;
    }

    public List<PedidoEntity> getPedidos() {
        return per.findAll();
    }

    public PedidoEntity getPedidoById(int id) {
        return per.findById(id).orElse(null);
    }
}
