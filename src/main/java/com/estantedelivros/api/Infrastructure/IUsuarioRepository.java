package com.estantedelivros.api.Infrastructure;

import com.estantedelivros.api.Domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface IUsuarioRepository extends MongoRepository<Usuario, UUID> {
}
