package com.example.ac1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ac1.model.Produto;
import com.example.ac1.model.Categoria;
import com.example.ac1.service.ProdutoService;
import com.example.ac1.service.CategoriaService;
import com.example.ac1.dto.ProdutoDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/cadastrar-produtos")
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = toEntity(produtoDTO);
        Produto novoProduto = produtoService.salvarProduto(produto);
        ProdutoDTO respostaDTO = toDTO(novoProduto);
        return ResponseEntity.ok(respostaDTO);
    }

    @GetMapping("/listar-produtos")
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<ProdutoDTO> produtosDTO = produtoService.listarProdutos()
                                                     .stream()
                                                     .map(this::toDTO)
                                                     .collect(Collectors.toList());
        return ResponseEntity.ok(produtosDTO);
    }

    @GetMapping("/exibir-produto/{id}")
    public ResponseEntity<ProdutoDTO> obterProdutoPorId(@PathVariable Integer id) {
        return produtoService.obterProdutoPorId(id)
                             .map(this::toDTO)
                             .map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private Produto toEntity(ProdutoDTO dto) {
        Categoria categoria = categoriaService.obterCategoriaPorId(dto.getCategoriaId())
                                              .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return new Produto(dto.getNome(), dto.getQuantidade(), categoria);
    }

    private ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(produto.getNome(), produto.getQuantidade(), produto.getCategoria().getIdCategoria());
    }
}