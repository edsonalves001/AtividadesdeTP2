package br.edu.fatecpg.tp2.ativ1.JDBC.model;

public class Tarefas {
    private String nomeTarefa;
    private String tipoTarefa;
    private String statusTarefa;

    public Tarefas(String nomeTarefa, String tipoTarefa, String statusTarefa) {
        this.nomeTarefa = nomeTarefa;
        this.tipoTarefa = tipoTarefa;
        this.statusTarefa = statusTarefa;
    }

    public String getTipoTarefa() {
        return tipoTarefa;
    }

    public void setTipoTarefa(String tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(String statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    @Override
    public String toString() {
        return "Tarefas{" +
                "nomeTarefa='" + nomeTarefa + '\'' +
                ", tipoTarefa='" + tipoTarefa + '\'' +
                ", statusTarefa='" + statusTarefa + '\'' +
                '}';
    }
}
