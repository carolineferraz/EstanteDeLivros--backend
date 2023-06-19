package com.estantedelivros.api.Domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;
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
    private List<Categoria> contagemCategoria;
    private List<UUID> livrosLidos; // lista com os id's dos livros que o usuário já leu
    private int pontuacao;

    public Usuario(String nome, String email, String senha){
        this.setId();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.trofeis = new ArrayList<Categoria>();
        this.contagemCategoria = new ArrayList<Categoria>();
        this.livrosLidos = new ArrayList<UUID>();
        this.pontuacao = 0;
    }

    protected void setId(){
        this.id = UUID.randomUUID();
    }

    public Boolean marcarOuDesmarcarLivroComoLido(UUID idLivro){
        if(livrosLidos.contains(idLivro)){
            this.livrosLidos.remove(idLivro);
            return false;
        } else {
            this.livrosLidos.add(idLivro);
            return true;
        }
    }

    public void adicionarCategoriaETrofeu(Categoria categoriaLivro){
        this.contagemCategoria.add(categoriaLivro);
        int qtdCategoria = Collections.frequency(this.contagemCategoria, categoriaLivro);
        if(qtdCategoria == 5){
            this.trofeis.add(categoriaLivro);
            this.contagemCategoria.removeAll(Collections.singleton(categoriaLivro));
        }
    }
    public void removerCategoriaOuTrofeu(Categoria categoriaLivro){
        int qtdCategoria = Collections.frequency(this.contagemCategoria, categoriaLivro);
        if(qtdCategoria == 0){
            this.trofeis.remove(categoriaLivro);
            for(int i = 1; i < 5; i++){
                this.contagemCategoria.add(categoriaLivro);
            }
        } else {
            this.contagemCategoria.remove(categoriaLivro);
        }
    }

    public void adicionarPontuacao(int qtdPaginasLivro){
        var quociente = Math.floorDiv(qtdPaginasLivro, 100);
        this.pontuacao += quociente + 1;
    }

    public void removerPontuacao(int qtdPaginasLivro){
        var quociente = Math.floorDiv(qtdPaginasLivro, 100);
        this.pontuacao -= quociente + 1;
    }
}
