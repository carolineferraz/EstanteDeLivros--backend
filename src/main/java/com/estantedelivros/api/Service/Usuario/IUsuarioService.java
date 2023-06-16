package com.estantedelivros.api.Service.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService {

    String cadastrarUsuario(DadosCadastroDeUsuario dados);

    Page<DadosListagemDeUsuarios> listarUsuarios(Pageable pageable);
}
