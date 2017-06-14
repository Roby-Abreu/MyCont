package com.abreu.roby.mycont;

/**
 * Created by hp on 19/05/2017.
 */

public class Feira {
    private int id_feira;
    private String nomeDafeira;
    private String dataAfeira;
    private String status;
    private double lucro_total;

    public Feira(){}
    public Feira(int id_feira, String nomeDafeira, String dataAfeira, String status, double lucro_total) {
        this.id_feira = id_feira;
        this.nomeDafeira = nomeDafeira;
        this.dataAfeira = dataAfeira;
        this.status = status;
        this.lucro_total = lucro_total;
    }

    public int getId_feira() {
        return id_feira;
    }

    public void setId_feira(int id_feira) {
        this.id_feira = id_feira;
    }

    public String getNomeDafeira() {
        return nomeDafeira;
    }

    public void setNomeDafeira(String nomeDafeira) {
        this.nomeDafeira = nomeDafeira;
    }

    public String getDataAfeira() {
        return dataAfeira;
    }

    public void setDataAfeira(String dataAfeira) {
        this.dataAfeira = dataAfeira;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getLucro_total() {
        return lucro_total;
    }

    public void setLucro_total(double lucro_total) {
        this.lucro_total = lucro_total;
    }
}
