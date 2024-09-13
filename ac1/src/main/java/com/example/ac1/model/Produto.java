package com.example.ac1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "prod_nome", nullable = false)
    private String nome;

    @Column(name = "prod_qtd", nullable = false)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    // Construtor com nome, quantidade e categoria
    public Produto(String nome, Integer quantidade, Categoria categoria) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    // Construtor padrão
    public Produto() {}

    // Getters e Setters
    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    @Override
public String toString() {
    return "Produto{" +
            "idProduto=" + idProduto +
            ", nome='" + nome + '\'' +
            ", quantidade=" + quantidade +
            ", categoria=" + (categoria != null ? categoria.getNome() : "null") +
            '}';
}
}