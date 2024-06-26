package com.pi.pizinho.controlador;

import com.pi.pizinho.data.PedidoEntity;
import com.pi.pizinho.data.PizzaEntity;
import com.pi.pizinho.service.PedidoService;
import com.pi.pizinho.service.PizzaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controlador {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/cadastrarP")
    public String cadastrarPizzas(Model model) {
        model.addAttribute("pizza", new PizzaEntity());
        return "cadastrarP";
    }

    @PostMapping("/cadastrarP")
    public String adicionarPizza(Model model, @ModelAttribute PizzaEntity pizza) {
        pizzaService.cadastraPizza(pizza);
        return "index";
    }

    @GetMapping("/verP")
    public String verPizzas(Model model) {
        model.addAttribute("listaPizza", pizzaService.getPizzas());
        return "verP";
    }

    @GetMapping("/realizarPedido")
    public String realizarPedido(Model model) {
        model.addAttribute("pedido", new PedidoEntity());
        model.addAttribute("listaPizza", pizzaService.getPizzas());
        return "realizarPedido";
    }

    @PostMapping("/realizarPedido")
    public String adicionarPedido(Model model, @ModelAttribute PedidoEntity pedido) {
        PizzaEntity pizza = pizzaService.getPizzaById(pedido.getPizza().getId());
        pedido.setPizza(pizza);
        pedido.calcularPrecoTotal();
        pedidoService.cadastraPedido(pedido);
        return "index";
    }

    @GetMapping("/verPedidos")
    public String verPedidos(Model model) {
        model.addAttribute("listaPedidos", pedidoService.getPedidos());
        return "verPedidos";
    }

    @PostMapping("/deletarPizza/{id}")
    public String deletarPizza(@PathVariable Integer id, Model model) {
        pizzaService.deletarPizza(id);
        model.addAttribute("listaPizza", pizzaService.getPizzas());
        return "verP";
    }

    @GetMapping("/editarPizza/{id}")
    public String verPizza(@PathVariable Integer id, Model model) {
        PizzaEntity p = pizzaService.getPizzaById(id);
        if (p != null) {
            model.addAttribute("pizza", p);
        }
        return "editarP";
    }

    @PostMapping("/editarPizza/{id}")
    public String editarPizza(@PathVariable Integer id, Model model, @ModelAttribute PizzaEntity pizza) {
        PizzaEntity p = pizzaService.getPizzaById(id);
        if (p != null) {
            pizza.setId(id);
            pizzaService.atualizarPizza(id, pizza);
        }
        return "index";
    }
}
