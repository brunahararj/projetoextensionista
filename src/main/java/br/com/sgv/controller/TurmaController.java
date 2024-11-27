package br.com.sgv.controller;

import br.com.sgv.model.Turma;
import br.com.sgv.repository.TurmaRepository;
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
 * @brief class ProdutoController
 */
@Controller
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping("/turma")
    public String listar(Model model) {
        model.addAttribute("listaTurma", turmaRepository.findAll());
        return "gerenciar_turma";
    }

    @GetMapping("/turma/novo")
    public String novo(Model model) {
        model.addAttribute("turma", new Turma());
        return "editar_turma";
    }

    @GetMapping("/turma/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Turma> turma = turmaRepository.findById(id);
        model.addAttribute("turma", turma.get());
        return "editar_turma";
    }

    @PostMapping("/turma")
    public String salvar(@Valid Turma turma, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_turma";
        }
        turmaRepository.save(turma);
        return "redirect:/turma";
    }

    @DeleteMapping("/turma/{id}")
    public String excluir(@PathVariable("id") long id) {
        turmaRepository.deleteById(id);
        return "redirect:/turma";
    }
}
