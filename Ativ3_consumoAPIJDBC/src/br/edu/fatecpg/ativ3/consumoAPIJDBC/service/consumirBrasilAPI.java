package br.edu.fatecpg.ativ3.consumoAPIJDBC.service;
import java.io.IOException;
import br.edu.fatecpg.ativ3.consumoAPIJDBC.model.empresa;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class consumirBrasilAPI {
private boolean valido;

    public boolean getValido() {
        return valido;
    }
    public String formatarCNPJ(String CNPJ){
        String [] format;
        String formatado = "";
        format = CNPJ.split("");
        for(int c=0; c<format.length;c++){
            try{
                Integer.parseInt(format[c]);
                formatado = formatado + format[c];
            }catch (NumberFormatException e){

            }
        }

        return formatado;
    }
    public String buscarCNPJ(String cnpj) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String CNPJ = "https://brasilapi.com.br/api/cnpj/v1/" + cnpj ;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(CNPJ))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() != 200){
            this.valido = false;
        }else{
            this.valido = true;
        }
        return response.body();

    }
}
