package com.estantedelivros.api.Infrastructure;

import com.estantedelivros.api.Domain.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ILivroRepository extends MongoRepository<Livro, UUID> {
}