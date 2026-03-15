package br.edu.fatecpg.ativ3.consumoAPIJDBC.model;

public class socio {
    private String nome_socio;
    private String cnpj_cpf_do_socio;
    private String qualificacao_socio;

    public socio(String nome_socio, String cnpj_cpf_do_socio, String qualificacao_socio) {
        this.nome_socio = nome_socio;
        this.cnpj_cpf_do_socio = cnpj_cpf_do_socio;
        this.qualificacao_socio = qualificacao_socio;
    }

    public String getNome_socio() {
        return nome_socio;
    }

    public void setNome_socio(String nome_socio) {
        this.nome_socio = nome_socio;
    }

    public String getCnpj_cpf_do_socio() {
        return cnpj_cpf_do_socio;
    }

    public void setCnpj_cpf_do_socio(String cnpj_cpf_do_socio) {
        this.cnpj_cpf_do_socio = cnpj_cpf_do_socio;
    }

    public String getqualificacao_socio() {
        return qualificacao_socio;
    }

    public void setqualificacao_socio(String qualificacao_socio) {
        this.qualificacao_socio = qualificacao_socio;
    }

    @Override
    public String toString() {
        return "socio{" +
                "nome_socio='" + nome_socio + '\'' +
                ", cnpj_cpf_do_socio='" + cnpj_cpf_do_socio + '\'' +
                ", qualificao_socio='" + qualificacao_socio + '\'' +
                '}';
    }
}
