package br.edu.fatecpg.tecprog2.controller;

import br.edu.fatecpg.tecprog2.model.*;
import br.edu.fatecpg.tecprog2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClimaController {

    @Autowired
    private ClimaService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/resultado")
    public String resultado(@RequestParam double latitude, @RequestParam double longitude, Model model) {

        ClimaDados dados = service.buscarClima(latitude, longitude);

        if (dados == null || dados.getCurrent() == null) {
            model.addAttribute("erro", "Não foi possível obter os dados climáticos");
            return "resultado";
        }

        model.addAttribute("clima", dados);
        model.addAttribute("descricao",
                service.traduzirCdClima(dados.getCurrent().getCdclima()));

        return "resultado";
    }
}