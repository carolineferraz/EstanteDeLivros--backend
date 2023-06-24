package com.estantedelivros.api.Infrastructure.Repositories;

import com.estantedelivros.api.Domain.Livro;
import com.estantedelivros.api.Service.Livro.DadosListagemDeLivros;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.UUID;

public interface ILivroRepository extends MongoRepository<Livro, UUID> {

    Page<DadosListagemDeLivros> findDadosListagemLivrosByTituloContainingIgnoreCase(String titulo, Pageable pageable);
}
