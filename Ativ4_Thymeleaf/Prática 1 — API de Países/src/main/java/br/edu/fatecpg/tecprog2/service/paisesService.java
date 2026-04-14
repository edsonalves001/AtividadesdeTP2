package br.edu.fatecpg.tecprog2.service;
import br.edu.fatecpg.tecprog2.model.Pais;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class paisesService {
    @Value("${paises.api.url}")
    private String urlPaises;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    public Pais buscarPaises(String nomePais) {
        try {
            String url = urlPaises + nomePais;
            String json = restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            Pais[] paises = mapper.readValue(json, Pais[].class);
            if (paises.length == 0) {
                return null;
            }
            return paises[0];
        } catch (Exception e) {
            throw new RuntimeException("Erro ao procurar o pais na API", e);
        }
    }
    }