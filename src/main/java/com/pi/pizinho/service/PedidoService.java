package com.pi.pizinho.service;

import com.pi.pizinho.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PedidoService {

    private int contador = 1;
    private ArrayList<Pedido> listaPedido;

    public PedidoService() {
        this.listaPedido = new ArrayList<>();
    }

    public void cadastraPedido(Pedido pedido) {
        pedido.setId(contador);
        pedido.calcularPrecoTotal();  
        listaPedido.add(pedido);
        contador++;
    }

    public void deletarPedido(Pedido pedido) {
        int id = pedido.getId();
        Iterator<Pedido> iterator = listaPedido.iterator();
        while (iterator.hasNext()) {
            Pedido p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public void atualizarPedido(int id, Pedido pedido) {
        for (Pedido p : listaPedido) {
            if (p.getId() == id) {
                p.setCliente(pedido.getCliente());
                p.setPrecoTotal(pedido.getPrecoTotal());
                p.setCpf(pedido.getCpf());
                p.setEndereco(pedido.getEndereco());
                p.setTelefone(pedido.getTelefone());
                p.setPizza(pedido.getPizza());
                p.setQuantidade(pedido.getQuantidade());
                p.calcularPrecoTotal();  
            }
        }
    }

    public List<Pedido> getPedidos() {
        return this.listaPedido;
    }

    public Pedido getPedidoById(int id) {
        for (Pedido p : listaPedido) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
