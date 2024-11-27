package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 22/04/2021
 * @brief class Produto
 */
@Entity
@Getter
@Setter

public class Turma extends Professor{

    @Id
    private long id;
    private String idioma;
    private String modalidade;
    private String nivel;
    

}

