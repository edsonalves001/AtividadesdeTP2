package br.edu.fatecpg.ativ2.consumoAPI.view;


import br.edu.fatecpg.ativ2.consumoAPI.model.endereco;
import br.edu.fatecpg.ativ2.consumoAPI.service.ConsomeAPI;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException, InterruptedException {
        try{
            Gson gson = new Gson();
            Scanner scan = new Scanner(System.in);
            ConsomeAPI ca = new ConsomeAPI();
            String cep = "";
            String resposta = "";
            boolean loop = false;
            while(loop == false){
                System.out.println("1-Adicionar CEP, 2-Buscar Endereço, 3-Excluir endereço, 4- Historico, 5- Sair ");
                String opt = scan.nextLine();
                switch (opt){
                    case "1":
                        System.out.println("Adicione o cep: ");
                        cep = scan.nextLine();
                        ca.adicionarCep(cep);
                        System.out.println("Digite S para Continuar e N para sair: ");
                        resposta = scan.nextLine().toLowerCase();
                        if(!resposta.equals("s")){
                            loop = true;
                        }
                        break;
                    case "2":
                        System.out.println("Procure o cep, substituindo os x pelo numero do cep(xxxxx-xxx): ");
                        cep = scan.nextLine();
                        ca.buscaCep(cep);
                        System.out.println("Digite S para Continuar e N para sair: ");
                        resposta = scan.nextLine().toLowerCase();
                        if(!resposta.equals("s")){
                            loop = true;
                        }
                        break;
                    case "3":
                        System.out.println("Digite o cep que deseja excluir, substituindo os x pelo numero do cep(xxxxx-xxx)");
                        cep = scan.nextLine();
                        ca.excluirCEP(cep);
                        System.out.println("Digite S para Continuar e N para sair: ");
                        resposta = scan.nextLine().toLowerCase();
                        if(!resposta.equals("s")){
                            loop = true;
                        }
                        break;
                    case "4":
                        ca.historicoCEP();
                        System.out.println("Digite S para Continuar e N para sair: ");
                        resposta = scan.nextLine().toLowerCase();
                        if(!resposta.equals("s")){
                            loop = true;
                        }
                        break;
                    case "5":
                        loop = true;

                }
            }


        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
