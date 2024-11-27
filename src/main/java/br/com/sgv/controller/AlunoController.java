package br.com.sgv.controller;

import br.com.sgv.model.Aluno;
import br.com.sgv.repository.AlunoRepository;
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
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 22/04/2021
 * @brief class PessoaFisicaController
 */
@Controller


public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/aluno")
    public String listar(Model model) {
        model.addAttribute("listaAluno", alunoRepository.findAll());
        return "gerenciar_aluno";
    }

    @GetMapping("/aluno/novo")
    public String novo(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "editar_aluno";
    }

    @GetMapping("/aluno/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Aluno> Aluno = alunoRepository.findById(id);
        model.addAttribute("aluno", Aluno.get());
        return "editar_aluno";
    }

    @PostMapping("/aluno")
    public String salvar(@Valid Aluno aluno, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_aluno";
        }
        alunoRepository.save(aluno);
        return "redirect:/aluno";
    }

    @DeleteMapping("/aluno/{id}")
    public String excluir(@PathVariable("id") long id) {
        alunoRepository.deleteById(id);
        return "redirect:/aluno";
    }
}