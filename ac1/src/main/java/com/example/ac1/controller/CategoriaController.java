package com.example.ac1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ac1.model.Categoria;
import com.example.ac1.service.CategoriaService;
import com.example.ac1.dto.CategoriaDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/cadastrar-categoria")
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = toEntity(categoriaDTO);
        Categoria novaCategoria = categoriaService.salvarCategoria(categoria);
        CategoriaDTO respostaDTO = toDTO(novaCategoria);
        return ResponseEntity.ok(respostaDTO);
    }

    @GetMapping("/listar-categorias")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        List<CategoriaDTO> categoriasDTO = categoriaService.listarCategorias()
                                                           .stream()
                                                           .map(this::toDTO)
                                                           .collect(Collectors.toList());
        return ResponseEntity.ok(categoriasDTO);
    }

    @GetMapping("/exibir-categoria/{id}")
    public ResponseEntity<CategoriaDTO> obterCategoriaPorId(@PathVariable Integer id) {
        return categoriaService.obterCategoriaPorId(id)
                               .map(this::toDTO)
                               .map(ResponseEntity::ok)
                               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private Categoria toEntity(CategoriaDTO dto) {
        return new Categoria(dto.getNome(), dto.getDescricao());
    }

    private CategoriaDTO toDTO(Categoria categoria) {
        return new CategoriaDTO(categoria.getNome(), categoria.getDescricao());
    }
}