package com.estantedelivros.api.Controller;

import com.estantedelivros.api.Service.Usuario.DadosCadastroUsuario;
import com.estantedelivros.api.Service.Usuario.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService _usuarioService;

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(DadosCadastroUsuario dados){
        var resposta = _usuarioService.cadastrarUsuario(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
}
