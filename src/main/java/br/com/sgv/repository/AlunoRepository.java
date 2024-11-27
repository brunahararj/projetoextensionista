package br.com.sgv.repository;


import br.com.sgv.model.Aluno;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 */
public interface AlunoRepository extends CrudRepository<Aluno,Long>{
    
}