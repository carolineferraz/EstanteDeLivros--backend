package com.estantedelivros.api.Controller;

import com.estantedelivros.api.Service.Usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService _usuarioService;

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid DadosCadastroDeUsuario dados){
        var resposta = _usuarioService.cadastrarUsuario(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemDeUsuarios>> listarUsuarios(@PageableDefault(size = 10, sort = {"pontuacao"}, direction = Sort.Direction.DESC) Pageable pageable){
        var resposta = _usuarioService.listarUsuarios(pageable);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoDeUsuario> detalharUsuario(@PathVariable UUID id){
        var resposta = _usuarioService.detalharUsuario(id);
        return ResponseEntity.ok(resposta);
    }

    @PutMapping("/{usuarioId}/{livroId}")
    public ResponseEntity marcarLivroComoLido(@PathVariable UUID usuarioId, @PathVariable UUID livroId){
        _usuarioService.marcarLivroComoLido(usuarioId, livroId);
        return ResponseEntity.noContent().build();
    }
}
