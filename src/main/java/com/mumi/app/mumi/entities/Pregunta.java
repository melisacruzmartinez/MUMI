package com.mumi.app.mumi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "pregunta")
public class Pregunta {
    @Id
    @Column(name = "pregunta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pregunta; // refiere a la pregunta en si (individual)
    @JsonIgnore
    @ManyToMany(mappedBy = "preguntas")
    private List<Categoria> categorias = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Pregunta(Integer id, String pregunta, List<Categoria> categorias) {
        this.id = id;
        this.pregunta = pregunta;
        this.categorias = categorias;
    }

    public Pregunta(){

    }

    public void agregarCategoria(Categoria categoria) {
        this.categorias.add(categoria);
        categoria.getPreguntas().add(this);
    }

   

}
