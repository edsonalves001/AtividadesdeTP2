package br.edu.fatecpg.tecprog2.service;

import br.edu.fatecpg.tecprog2.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {

    private final RestTemplate restTemplate = new RestTemplate();
    public ClimaDados buscarClima(double lat, double lon) {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + lat +
                "&longitude=" + lon +
                "&current=temperature_2m,windspeed_10m,weathercode" +
                "&timezone=America/Sao_Paulo";

        return restTemplate.getForObject(url, ClimaDados.class);
    }

    public String traduzirCdClima(int cd) {
        if (cd == 0) return "Céu limpo";
        if (cd >= 1 && cd <= 3) return "Parcialmente nublado";
        if (cd >= 45 && cd <= 48) return "Neblina";
        if (cd >= 61 && cd <= 67) return "Chuva";
        if (cd >= 71 && cd <= 77) return "Neve";
        if (cd >= 80 && cd <= 82) return "Pancadas de chuva";
        return "Condição desconhecida";
    }
}
