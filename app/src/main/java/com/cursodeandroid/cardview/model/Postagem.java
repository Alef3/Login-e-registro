package com.cursodeandroid.cardview.model;


public class Postagem {

    private String nome;
    private String descricao, hora;
    private int imagem;

    public Postagem() { }

    public Postagem(String nome, String descricao, int imagem, String hora) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getHora() {
        return hora;
    }
}
