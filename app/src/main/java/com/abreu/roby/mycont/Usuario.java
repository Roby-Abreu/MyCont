package com.abreu.roby.mycont;

/**
 * Created by hp on 17/05/2017.
 */

class Usuario {
    private int id_usuario;
    private String nome_usuario;
    private String login;
    private String senha;
    private String email;

    public Usuario(){}

    public Usuario(int id_usuario, String nome_usuario, String login, String senha, String email) {
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Nome: "+this.getNome_usuario()+"\n"+"Login: "+this.getLogin()+"\n"+"Email: "+
                this.getEmail();
    }
}
