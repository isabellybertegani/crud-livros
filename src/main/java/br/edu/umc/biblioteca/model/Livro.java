package br.edu.umc.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório.")
    @Size(min = 2, max = 120, message = "O título deve ter entre 2 e 120 caracteres.")
    private String titulo;

    @NotBlank(message = "O autor é obrigatório.")
    @Size(min = 3, max = 80, message = "O autor deve ter entre 3 e 80 caracteres.")
    private String autor;

    @NotNull(message = "O ano é obrigatório.")
    @Min(value = 1000, message = "O ano deve ser maior ou igual a 1000.")
    @Max(value = 2100, message = "O ano deve ser menor ou igual a 2100.")
    private Integer ano;

    @NotBlank(message = "O gênero é obrigatório.")
    @Size(max = 50, message = "O gênero deve ter no máximo 50 caracteres.")
    private String genero;

    // Construtor vazio (exigido pelo JPA)
    public Livro() {
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
