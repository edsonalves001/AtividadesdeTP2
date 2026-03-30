package br.edu.fatecpg.tecprog2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClimaAtual {

    @JsonProperty("time")
    private String tempo;

    @JsonProperty("temperature_2m")
    private double temperatura;

    @JsonProperty("windspeed_10m")
    private double veloventos;

    @JsonProperty("weathercode")
    private int cdclima;

    public String getTempo() {
        return tempo;
    }
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public double getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getVeloventos() {
        return veloventos;
    }
    public void setVeloventos(double veloventos) {
        this.veloventos = veloventos;
    }

    public int getCdclima() {
        return cdclima;
    }
    public void setCdclima(int cdclima) {
        this.cdclima = cdclima;
    }
}