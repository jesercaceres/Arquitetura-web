package com.example.ac1.dto;

public class ProdutoDTO {
    private String nome;
    private Integer quantidade;
    private Integer categoriaId;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nome, Integer quantidade, Integer categoriaId) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoriaId = categoriaId;
    }

    public ProdutoDTO(String nome, Integer quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
}
