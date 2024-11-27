package br.com.sgv.controller;

import br.com.sgv.model.Pessoa;
import br.com.sgv.repository.PessoaRepository;
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
public class PessoaController{

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/pessoa")
    public String listar(Model model) {
        model.addAttribute("listaPessoa", pessoaRepository.findAll());
        return "gerenciar_pessoa";
    }

    @GetMapping("/pessoa/novo")
    public String novo(Model model) {
        model.addAttribute("pessoa", new Pessoa() {});
        return "editar_pessoa";
    }

    @GetMapping("/pessoa/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        model.addAttribute("pessoa", pessoa.get());
        return "editar_pessoa";
    }

    @PostMapping("/pessoa")
    public String salvar(@Valid Pessoa pessoa, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_pessoa";
        }
        pessoaRepository.save(pessoa);
        return "redirect:/pessoa";
    }

    @DeleteMapping("/pessoa/{id}")
    public String excluir(@PathVariable("id") long id) {
        pessoaRepository.deleteById(id);
        return "redirect:/pessoa";
    }
}
