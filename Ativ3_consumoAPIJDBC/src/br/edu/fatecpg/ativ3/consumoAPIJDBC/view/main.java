package br.edu.fatecpg.ativ3.consumoAPIJDBC.view;
//CNPJ COM QSA PARA TESTE: 34925681000110
import br.edu.fatecpg.ativ3.consumoAPIJDBC.DB.db;
import br.edu.fatecpg.ativ3.consumoAPIJDBC.model.empresa;
import br.edu.fatecpg.ativ3.consumoAPIJDBC.model.socio;
import br.edu.fatecpg.ativ3.consumoAPIJDBC.service.consumirBrasilAPI;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main (String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        String CNPJ = "";
        String loop = "sim";
        consumirBrasilAPI cbAPI = new consumirBrasilAPI();
        do{
            try{
                System.out.println("Digite o CNPJ que deseja buscar: ");
                CNPJ = scan.next();
                Gson gson = new Gson();
                cbAPI.buscarCNPJ(cbAPI.formatarCNPJ(CNPJ));
                if(cbAPI.getValido()){
                    System.out.println("CNPJ valido");
                    try(var conn = db.connection()){
                        empresa emp = gson.fromJson(cbAPI.buscarCNPJ(CNPJ),empresa.class);
                        var query = "INSERT INTO tb_empresas(razao_social,nome_fantasia,logradouro,\"CNPJ\") VALUES(?,?,?,?)";
                        PreparedStatement stmt = conn.prepareStatement(query);
                        stmt.setString(1,emp.getRazao_social());
                        stmt.setString(2,emp.getNome_fantasia());
                        stmt.setString(3,emp.getLogradouro());
                        stmt.setString(4,emp.getCnpj());
                        stmt.execute();
                        if(!emp.getQsa().isEmpty()) {
                            var novaQuery = "INSERT INTO tb_socios(cpf_cnpj_do_socio,nome_socio,qualificacao_socio) values (?,?,?)";
                            for (socio soc : emp.getQsa()) {
                                PreparedStatement stmt2 = conn.prepareStatement(novaQuery);
                                stmt2.setString(1, soc.getCnpj_cpf_do_socio());
                                stmt2.setString(2, soc.getNome_socio());
                                stmt2.setString(3, soc.getqualificacao_socio());
                                stmt2.execute();
                            }
                        }
                    }catch (SQLException e){
                        System.err.println(e.getMessage());
                    }
                }else{
                    System.out.println("CNPJ invalido");
                }
            }catch (IOException e) {
                System.err.println(e.getMessage());
            }
            System.out.println("Deseja cadastrar um novo CNPJ? (s para continuar e n para sair): ");
            loop = scan.next();
        }while(!loop.toLowerCase().equals("n"));



        scan.close();
    }
}