package br.edu.umc.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.umc.biblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    // Query Method: busca por parte do título, sem diferenciar maiúsculas/minúsculas
    List<Livro> findByTituloContainingIgnoreCase(String titulo);
}
