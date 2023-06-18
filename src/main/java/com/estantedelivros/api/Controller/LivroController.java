package com.estantedelivros.api.Controller;

import com.estantedelivros.api.Domain.Livro;
import com.estantedelivros.api.Service.Livro.DadosCadastroDeLivro;
import com.estantedelivros.api.Service.Livro.DadosListagemDeLivros;
import com.estantedelivros.api.Service.Livro.ILivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/livro")
public class LivroController {

    @Autowired
    private ILivroService _livroService;

    @PostMapping
    public ResponseEntity<String> cadastrarLivro(@RequestBody @Valid DadosCadastroDeLivro dados){
        var resposta = _livroService.cadastrarLivro(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemDeLivros>> listarLivros(@PageableDefault(size = 10, sort = {"titulo"}) Pageable pageable){
        var resposta = _livroService.listarLivros(pageable);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> detalharLivro(@PathVariable UUID id){
        var resposta = _livroService.detalharLivro(id);
        return ResponseEntity.ok(resposta);
    }
}
