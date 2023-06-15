package com.estantedelivros.api.Service.Usuario;

import com.estantedelivros.api.Domain.Usuario;
import com.estantedelivros.api.Infrastructure.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository _usuarioRepository;

    public String cadastrarUsuario(DadosCadastroUsuario dados){
        var usuario = new Usuario(dados.nome(), dados.email(), dados.senha());
        _usuarioRepository.save(usuario);
        return usuario.getId().toString();
    }
}
