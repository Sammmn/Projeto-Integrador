package com.pi.pizinho.controlador;

import com.pi.pizinho.model.Pedido;
import com.pi.pizinho.model.Pizza;
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
        model.addAttribute("pizza", new Pizza());
        return "cadastrarP";
    }

    @PostMapping("/cadastrarP")
    public String adicionarPizza(Model model, @ModelAttribute Pizza pizza) {
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
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("listaPizza", pizzaService.getPizzas());
        return "realizarPedido";
    }

    @PostMapping("/realizarPedido")
    public String adicionarPedido(Model model, @ModelAttribute Pedido pedido) {
        Pizza pizza = pizzaService.getPizzaById(pedido.getPizza().getId());
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
        Pizza p = pizzaService.getPizzaById(id);
        if (p != null) {
            model.addAttribute("pizza", p);
        }
        return "editarP";
    }

    @PostMapping("/editarPizza/{id}")
    public String editarPizza(@PathVariable Integer id, Model model, @ModelAttribute Pizza pizza) {
        Pizza p = pizzaService.getPizzaById(id);
        if (p != null) {
            pizza.setId(id);
            pizzaService.atualizarPizza(id, pizza);
        }
        return "index";
    }
}
