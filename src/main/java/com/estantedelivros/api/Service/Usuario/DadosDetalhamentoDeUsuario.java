package com.estantedelivros.api.Service.Usuario;

import com.estantedelivros.api.Domain.Categoria;
import com.estantedelivros.api.Domain.Usuario;

import java.util.List;
import java.util.UUID;

public record DadosDetalhamentoDeUsuario(
        UUID id,
        String nome,
        List<Categoria> trofeis,
        List<UUID> livrosLidos,
        int pontuacao
) {

    public DadosDetalhamentoDeUsuario(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getTrofeis(),
                usuario.getLivrosLidos(),
                usuario.getPontuacao()
        );
    }
}
