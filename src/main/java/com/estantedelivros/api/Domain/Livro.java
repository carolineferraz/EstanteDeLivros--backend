package com.estantedelivros.api.Domain;

import com.estantedelivros.api.Service.Livro.DadosCadastroDeLivro;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Data
@Document
public class Livro {

    @Id
    private UUID id;
    private String titulo;
    private String descricao;
    private int qtdPaginas;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String foto;

    public Livro(String titulo, String descricao, int qtdPaginas, Categoria categoria, String foto) {
        this.setId();
        this.titulo = titulo;
        this.descricao = descricao;
        this.qtdPaginas = qtdPaginas;
        this.categoria = categoria;
        this.foto = foto;
    }

    protected void setId(){
        this.id = UUID.randomUUID();
    }
}
