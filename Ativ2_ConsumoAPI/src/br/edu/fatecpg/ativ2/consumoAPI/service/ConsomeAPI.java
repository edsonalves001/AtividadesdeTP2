package br.edu.fatecpg.ativ2.consumoAPI.service;

import br.edu.fatecpg.ativ2.consumoAPI.model.endereco;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConsomeAPI {
    List <endereco> historico = new ArrayList<>();
    List<String> buscado = new ArrayList<>();

    public void adicionarCep(String end) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String cep = "https://viacep.com.br/ws/" + end + "/json/";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(cep)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().contains("\"erro\"")){
            System.out.println("CEP não encontrado");
        }else{
            Gson gson = new Gson();
            endereco infos = gson.fromJson(response.body(), endereco.class);
            historico.add(infos);
        }
    }
    public void excluirCEP(String end){
        boolean encontrado = false;
        for(int c = 0; c < historico.size(); c++){
            if(historico.get(c).getCep().equals(end)){
                historico.remove(c);
                System.out.println("CEP removido");
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("Esse CEP não está na lista");
        }
    }
    public void historicoCEP(){
        for(int c = buscado.size()-1; c>=0;c--){
            System.out.println(c+1 + "º buscado no historico: " + buscado.get(c));
        }
    }
    public String buscaCep(String end) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        boolean encontrado = false;
        for(int c = 0; c < historico.size(); c++){

            if(historico.get(c).getCep().equals(end)){
                buscado.add(historico.get(c).getCep());
                encontrado = true;
                break;
            }

        }
        if(encontrado){
            System.out.println("Cep encontrado na lista");
        }else{
            System.out.println("Esse CEP não está na lista");
        }
        String cep = "https://viacep.com.br/ws/" + end + "/json/";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(cep))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().contains("\"erro\"")){
            System.out.println("CEP não encontrado");
        }else if(!encontrado){
            System.out.println("CEP válido");
        }


        return response.body();

    }
}
