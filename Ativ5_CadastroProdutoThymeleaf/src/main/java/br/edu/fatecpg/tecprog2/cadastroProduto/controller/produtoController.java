package br.edu.fatecpg.tecprog2.cadastroProduto.controller;
import br.edu.fatecpg.tecprog2.cadastroProduto.model.produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class produtoController {
    private static final List<produto> produtos = new ArrayList<>();

    @GetMapping("/")
    public String index(){
        return "redirect:/cadastrar";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("produto",new produto());
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto(@ModelAttribute produto produto){
        produtos.add(produto);
        return "redirect:/lista";
    }
    @PostMapping("/remover")
    public String removerProduto(@RequestParam int index){
        produtos.remove(index);
        return "redirect:/lista";
    }
    @GetMapping("/lista")
    public String exibirLista(Model model){
        model.addAttribute("produtos",produtos);
        return "lista";
    }
}
