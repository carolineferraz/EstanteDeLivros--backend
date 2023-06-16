package com.estantedelivros.api.Service.Usuario;

import com.estantedelivros.api.Domain.Usuario;
import com.estantedelivros.api.Infrastructure.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository _usuarioRepository;

    public String cadastrarUsuario(DadosCadastroDeUsuario dados){
        var usuario = new Usuario(dados.nome(), dados.email(), dados.senha());
        _usuarioRepository.save(usuario);
        System.out.println(usuario.getNome());
        return usuario.getId().toString();
    }

    public Page<DadosListagemDeUsuarios> listarUsuarios(Pageable pageable){
        return _usuarioRepository.findAll(pageable).map(DadosListagemDeUsuarios::new);
    }
}
