package com.estantedelivros.api.Service.Livro;

import com.estantedelivros.api.Domain.Livro;
import com.estantedelivros.api.Infrastructure.Repositories.ILivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class LivroService implements ILivroService {

    @Autowired
    private ILivroRepository _livroRepository;

    public String cadastrarLivro(DadosCadastroDeLivro dados){
        var livro = new Livro(dados.titulo(), dados.descricao(), dados.qtdPaginas(), dados.categoria(), dados.foto());
        _livroRepository.save(livro);
        return livro.getId().toString();
    }

    public Page<DadosListagemDeLivros> listarLivros(Pageable pageable) {
        return _livroRepository.findAll(pageable).map(DadosListagemDeLivros::new);
    }

    public Livro detalharLivro(UUID id){
        var optional = _livroRepository.findById(id);
        Livro livro = optional.orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
        return livro;
    }

    public Page<DadosListagemDeLivros> listarLivrosPorTitulo(Pageable pageable, String titulo) {
        return _livroRepository.findDadosListagemLivrosByTituloContainingIgnoreCase(titulo, pageable);
    }
}
