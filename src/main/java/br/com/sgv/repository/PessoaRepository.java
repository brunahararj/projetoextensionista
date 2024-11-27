package br.com.sgv.repository;


import br.com.sgv.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 */
public interface PessoaRepository extends CrudRepository<Pessoa,Long>{
    
}
