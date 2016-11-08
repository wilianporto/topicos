package br.edu.unidavi.topicos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.springframework.hateoas.ResourceSupport;


@Entity
@SequenceGenerator(name = "estado_id_seq",
        sequenceName = "estado_id_seq",
        allocationSize = 1)
public class Estado extends ResourceSupport 
        implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "estado_id_seq")
    private Long id;
    
    @NotNull(message = "A UF do Estado não pode ser nula!")
    @Column(unique = true
            , nullable = false
            , updatable = false
            , length = 2)
    private String uf;
    
    @NotNull(message = "O nome do Estado não pode ser nulo!")
    @Column(nullable = false, length = 30)
    private String nome;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
