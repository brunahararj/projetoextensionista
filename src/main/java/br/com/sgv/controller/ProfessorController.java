package br.com.sgv.controller;

import br.com.sgv.model.Professor;
import br.com.sgv.repository.ProfessorRepository;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 22/04/2021
 * @brief class PessoaFisicaController
 */
@Controller
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/professor")
    public String listar(Model model) {
        model.addAttribute("listaProfessor", professorRepository.findAll());
        return "gerenciar_professor";
    }

    @GetMapping("/professor/novo")
    public String novo(Model model) {
        model.addAttribute("professor", new Professor());
        return "editar_professor";
    }

    @GetMapping("/professor/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Professor> professor = professorRepository.findById(id);
        model.addAttribute("professor", professor.get());
        return "editar_professor";
    }

    @PostMapping("/professor")
    public String salvar(@Valid Professor professor, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_professor";
        }
        professorRepository.save(professor);
        return "redirect:/professor";
    }

    @DeleteMapping("/professor/{id}")
    public String excluir(@PathVariable("id") long id) {
        professorRepository.deleteById(id);
        return "redirect:/professor";
    }
}
