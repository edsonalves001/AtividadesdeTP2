package br.edu.fatecpg.tecprog2.controller;
import br.edu.fatecpg.tecprog2.model.Pais;
import br.edu.fatecpg.tecprog2.service.paisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {
    @Autowired private paisesService paisesService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/procurar/{name}")
    public String procurar(@PathVariable String name, Model model){
        Pais nomePais = paisesService.buscarPaises(name);
        if(nomePais == null){
            model.addAttribute("erro","Nome \""+ name + "\" Não encontrado");
        }else{
            model.addAttribute("nome",nomePais);
        }
        return "resultado";
    }
}
