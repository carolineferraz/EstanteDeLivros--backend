package com.estantedelivros.api.Service.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IUsuarioService {

    String cadastrarUsuario(DadosCadastroDeUsuario dados);

    Page<DadosListagemDeUsuarios> listarUsuarios(Pageable pageable);

    DadosDetalhamentoDeUsuario detalharUsuario(UUID id);

    void marcarLivroComoLido(UUID usuarioId, UUID livroId);
}