package br.edu.umc.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.umc.biblioteca.model.Livro;
import br.edu.umc.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

    private final LivroRepository repository;

    // Injeção do Repository pelo construtor
    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listar() {
        return repository.findAll();
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo);
    }

    public Livro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado: " + id));
    }

    public Livro salvar(Livro livro) {
        return repository.save(livro);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
