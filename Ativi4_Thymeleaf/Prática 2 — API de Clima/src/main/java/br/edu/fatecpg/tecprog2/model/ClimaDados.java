package br.edu.fatecpg.tecprog2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClimaDados {

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("current")
    private ClimaAtual current;

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }

    public ClimaAtual getCurrent() { return current; }
    public void setCurrent(ClimaAtual current) { this.current = current; }
}