package br.com.sgv.repository;


import br.com.sgv.model.Professor;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 */
public interface ProfessorRepository extends CrudRepository<Professor,Long>{
    
}
