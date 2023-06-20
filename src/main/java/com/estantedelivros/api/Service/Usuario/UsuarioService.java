package com.estantedelivros.api.Service.Usuario;

import com.estantedelivros.api.Domain.Usuario;
import com.estantedelivros.api.Infrastructure.Repositories.IUsuarioRepository;
import com.estantedelivros.api.Service.Livro.ILivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository _usuarioRepository;

    @Autowired
    private ILivroService _livroService;

    public String cadastrarUsuario(DadosCadastroDeUsuario dados){
        var usuario = new Usuario(dados.nome(), dados.email(), dados.senha());
        _usuarioRepository.save(usuario);
        System.out.println(usuario.getNome());
        return usuario.getId().toString();
    }

    public Page<DadosListagemDeUsuarios> listarUsuarios(Pageable pageable){
        return _usuarioRepository.findAll(pageable).map(DadosListagemDeUsuarios::new);
    }

    public DadosDetalhamentoDeUsuario detalharUsuario(UUID id){
        var usuario = obterUsuarioPeloId(id);
        return new DadosDetalhamentoDeUsuario(usuario);
    }

    public void marcarLivroComoLido(UUID usuarioId, UUID livroId){
        var usuario = obterUsuarioPeloId(usuarioId);
        var marcarLido = usuario.marcarOuDesmarcarLivroComoLido(livroId);
        var categoriaLivro = _livroService.detalharLivro(livroId).getCategoria();
        if(marcarLido){
            usuario.adicionarCategoriaETrofeu(categoriaLivro);
            usuario.adicionarPontuacao(_livroService.detalharLivro(livroId).getQtdPaginas());
        } else {
            usuario.removerCategoriaOuTrofeu(categoriaLivro);
            usuario.removerPontuacao(_livroService.detalharLivro(livroId).getQtdPaginas());
        }

        _usuarioRepository.save(usuario);
    }

    private Usuario obterUsuarioPeloId(UUID id){
        var optional = _usuarioRepository.findById(id);
        Usuario usuario = optional.orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
        return usuario;
    }
}
