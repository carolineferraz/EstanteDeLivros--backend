package com.estantedelivros.api.Infrastructure.Repositories;

import com.estantedelivros.api.Domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface IUsuarioRepository extends MongoRepository<Usuario, UUID> {

    UserDetails findByEmail(String email);
}
