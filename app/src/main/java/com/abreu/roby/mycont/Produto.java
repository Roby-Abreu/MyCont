package com.abreu.roby.mycont;

/**
 * Created by hp on 17/05/2017.
 */

public class Produto {
    private int id_produto;
    private String nome_produto;
    private int quantidade;
    private double valorDEproducao;
    private double valorDEvenda;

    public Produto(){}

    public Produto(int id_produto, String nome_produto, int quantidade, double valorDEproducao, double valorDEvenda) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.quantidade = quantidade;
        this.valorDEproducao = valorDEproducao;
        this.valorDEvenda = valorDEvenda;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorDEproducao() {
        return valorDEproducao;
    }

    public void setValorDEproducao(double valorDEproducao) {
        this.valorDEproducao = valorDEproducao;
    }

    public double getValorDEvenda() {
        return valorDEvenda;
    }

    public void setValorDEvenda(double valorDEvenda) {
        this.valorDEvenda = valorDEvenda;
    }

    public String toString(){
        return "Produto: "+this.getNome_produto()+"\n"+"QTD: "+this.getQuantidade()+"\n"+
                "Preço: "+this.getValorDEvenda();
    }
}
