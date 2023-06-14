package com.estantedelivros.api.Domain;

import com.estantedelivros.api.Domain.Categoria;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class Livro {

    @Id
    private UUID id;
    private String titulo;
    private String descricao;
    private int qtdPaginas;
    private Categoria categoria;
    private String foto;
}
