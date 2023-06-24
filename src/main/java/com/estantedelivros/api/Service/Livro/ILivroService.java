package com.estantedelivros.api.Service.Livro;

import com.estantedelivros.api.Domain.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ILivroService {

    String cadastrarLivro(DadosCadastroDeLivro dados);

    Page<DadosListagemDeLivros> listarLivros(Pageable pageable);

    Page<DadosListagemDeLivros> listarLivrosPorTitulo(Pageable pageable, String titulo);

    public Livro detalharLivro(UUID id);
}
