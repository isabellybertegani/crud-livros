package br.edu.umc.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.umc.biblioteca.model.Livro;
import br.edu.umc.biblioteca.service.LivroService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    // LISTAR (com busca opcional por título)
    @GetMapping
    public String listar(@RequestParam(required = false) String busca, Model model) {
        if (busca != null && !busca.isBlank()) {
            model.addAttribute("livros", service.buscarPorTitulo(busca.trim()));
            model.addAttribute("busca", busca.trim());
        } else {
            model.addAttribute("livros", service.listar());
        }
        return "livros/lista";
    }

    // NOVO: abre o formulário vazio
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    // SALVAR (cadastro e edição): valida e faz redirect para evitar duplicidade ao recarregar
    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("livro") Livro livro,
                         BindingResult result,
                         RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "livros/form";
        }
        boolean novo = (livro.getId() == null);
        service.salvar(livro);
        redirect.addFlashAttribute("mensagem",
                novo ? "Livro cadastrado com sucesso!" : "Livro atualizado com sucesso!");
        return "redirect:/livros";
    }

    // EDITAR: abre o formulário preenchido
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("livro", service.buscarPorId(id));
        return "livros/form";
    }

    // EXCLUIR
    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirect) {
        service.excluir(id);
        redirect.addFlashAttribute("mensagem", "Livro excluído com sucesso!");
        return "redirect:/livros";
    }
}
