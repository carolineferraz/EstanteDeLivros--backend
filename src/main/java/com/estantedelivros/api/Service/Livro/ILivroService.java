package com.estantedelivros.api.Service.Livro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILivroService {

    String cadastrarLivro(DadosCadastroDeLivro dados);

    Page<DadosListagemDeLivros> listarLivros(Pageable pageable);
}