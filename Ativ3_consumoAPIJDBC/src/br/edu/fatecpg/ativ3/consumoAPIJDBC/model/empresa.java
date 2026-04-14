package br.edu.fatecpg.ativ3.consumoAPIJDBC.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class empresa {
  private String cnpj;
  private String razao_social;
  private String nome_fantasia;
  private String logradouro;
  private ArrayList<socio> qsa;

    public empresa(String cnpj, String nome_fantasia, String razao_social, String logradouro, ArrayList<socio> qsa) {
        this.cnpj = cnpj;
        this.nome_fantasia = nome_fantasia;
        this.razao_social = razao_social;
        this.logradouro = logradouro;
        this.qsa = qsa;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public ArrayList<socio> getQsa() {
        return qsa;
    }

    public void setQsa(ArrayList<socio> qsa) {
        this.qsa = qsa;
    }
    @Override
    public String toString() {
        return "empresa{" +
                "cnpj='" + cnpj + '\'' +
                ", razao_social='" + razao_social + '\'' +
                ", nome_fantasia='" + nome_fantasia + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", qsa=" + qsa +
                '}';
    }
}
