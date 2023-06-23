package com.estantedelivros.api.Controller;

import com.estantedelivros.api.Domain.Usuario;
import com.estantedelivros.api.Infrastructure.Security.TokenService;
import com.estantedelivros.api.Service.Autenticacao.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager _authenticationManager;

    @Autowired
    private TokenService _tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DadosAutenticacao dados){
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var autentication = _authenticationManager.authenticate(token);

        return ResponseEntity.ok(_tokenService.gerarToken((Usuario) autentication.getPrincipal()));
    }
}
