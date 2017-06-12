package com.abreu.roby.mycont;

/**
 * Created by hp on 22/05/2017.
 */

public class Gasto {
    private int id_gasto;
    private int id_feira;
    private String tipo;
    private double valorGasto;
    private String dataGasto;
    private String nomeFeira;


    public Gasto(){}

    public Gasto(int id_gasto, int id_feira, String tipo, double valorGasto, String dataGasto, String nomeFeira) {
        this.id_gasto = id_gasto;
        this.id_feira = id_feira;
        this.tipo = tipo;
        this.valorGasto = valorGasto;
        this.dataGasto = dataGasto;
        this.nomeFeira = nomeFeira;
    }


    public int getId_gasto() {
        return id_gasto;
    }

    public void setId_gasto(int id_gasto) {
        this.id_gasto = id_gasto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public String getDataGasto() {
        return dataGasto;
    }

    public void setDataGasto(String dataGasto) {
        this.dataGasto = dataGasto;
    }

    public String getNomeFeira() {
        return nomeFeira;
    }

    public void setNomeFeira(String nomeFeira) {
        this.nomeFeira = nomeFeira;
    }

    public int getId_feira() {
        return id_feira;
    }

    public void setId_feira(int id_feira) {
        this.id_feira = id_feira;
    }

    public String toString(){
        return  "Feira: "+this.getNomeFeira()+"\n"+"Data:"+this.getDataGasto()+"\n"+"Tipo:"+this.getTipo()+"" +
                "\n"+"Valor: R$ "+this.getValorGasto();
    }
}
