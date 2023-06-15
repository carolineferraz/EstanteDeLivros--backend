package com.estantedelivros.api.Domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document
public class Usuario {

    @Id
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private List<Categoria> trofeis;
    private List<UUID> livrosLidos; // lista com os id's dos livros que o usuário já leu
    private int pontuacao;

    public Usuario(String nome, String email, String senha){
        this.setId();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.trofeis = new ArrayList<Categoria>();
        this.livrosLidos = new ArrayList<UUID>();
        this.pontuacao = 0;
    }

    protected void setId(){
        this.id = UUID.randomUUID();
    }
}
