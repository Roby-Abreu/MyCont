package com.abreu.roby.mycont;

/**
 * Created by hp on 19/05/2017.
 */

public class Venda {
    private int id_venda;
    private int id_feira;
    private double valorDAvenda;
    private int quantidade;
    private String nome_produto;
    private String formaDEpagamento;
    private String nomeDAfeira;
    private String dataDAfeira;

    public Venda(){}

    public Venda(int id_venda, int id_feira, double valorDAvenda, int quantidade, String nome_produto, String formaDEpagamento,
                 String nomeDAfeira, String dataDAfeira) {
        this.id_venda = id_venda;
        this.id_feira = id_feira;
        this.valorDAvenda = valorDAvenda;
        this.quantidade = quantidade;
        this.nome_produto = nome_produto;
        this.formaDEpagamento = formaDEpagamento;
        this.nomeDAfeira = nomeDAfeira;
        this.dataDAfeira = dataDAfeira;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public double getValorDAvenda() {
        return valorDAvenda;
    }

    public void setValorDAvenda(double valorDAvenda) {
        this.valorDAvenda = valorDAvenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFormaDEpagamento() {
        return formaDEpagamento;
    }

    public void setFormaDEpagamento(String formaDEpagamento) {
        this.formaDEpagamento = formaDEpagamento;
    }

    public String getNomeDAfeira() {
        return nomeDAfeira;
    }

    public void setNomeDAfeira(String nomeDAfeira) {
        this.nomeDAfeira = nomeDAfeira;
    }

    public String getDataDAfeira() {
        return dataDAfeira;
    }

    public void setDataDAfeira(String dataDAfeira) {
        this.dataDAfeira = dataDAfeira;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public int getId_feira() {
        return id_feira;
    }

    public void setId_feira(int id_feira) {
        this.id_feira = id_feira;
    }

    public String toString(){
        return "Feira: "+this.getNomeDAfeira()+"\n"+"Data: "+this.getDataDAfeira()+"\n"+"Valor: "+this.getValorDAvenda()+"\n"+
                "Produto: "+this.getNome_produto();
    }
}
