package br.edu.fatecpg.tecprog2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Pais {

    @JsonProperty("name")
    private Nome nome;

    @JsonProperty("capital")
    private List<String> capitais;

    @JsonProperty("region")
    private String regiao;

    @JsonProperty("subregion")
    private String subregiao;

    @JsonProperty("population")
    private long populacao;

    @JsonProperty("area")
    private double area;

    @JsonProperty("flags")
    private Bandeira bandeira;


    public static class Nome {
        @JsonProperty("common")
        private String nomeComum;

        @JsonProperty("official")
        private String nomeOficial;

        public String getNomeOficial() {
            return nomeOficial;
        }

        public void setNomeOficial(String nomeOficial) {
            this.nomeOficial = nomeOficial;
        }

        public String getNomeComum() {
            return nomeComum;
        }

        public void setNomeComum(String nomeComum) {
            this.nomeComum = nomeComum;
        }
    }

    public static class Bandeira {
        @JsonProperty("png")
        private String png;

        public String getPng() {
            return png;
        }

        public void setPng(String png) {
            this.png = png;
        }
    }

    public Nome getNome() {
        return nome;
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }

    public List<String> getCapitais() {
        return capitais;
    }

    public void setCapitais(List<String> capitais) {
        this.capitais = capitais;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSubregiao() {
        return subregiao;
    }

    public void setSubregiao(String subregiao) {
        this.subregiao = subregiao;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }
}