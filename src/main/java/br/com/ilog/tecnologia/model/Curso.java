package br.com.ilog.tecnologia.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private String cargaHoraria;
    private Integer valor;
    
    @ManyToMany
    @JoinTable(name="cursos_has_pessoas", joinColumns = 
    {@JoinColumn(name="curso_id")}, inverseJoinColumns = 
    {@JoinColumn(name="usuario_id")})
    private List<Usuario> usuarios;

    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
