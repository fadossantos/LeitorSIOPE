package br.gov.sp.policiamilitar.business.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "Permissoes.findAll", query = "SELECT s FROM Permissoes s")
public class Permissoes implements Serializable {

    private static final long serialVersionUID = -4827888840382144886L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermissoes;
    @Column(unique = true)
    private String descPermissoes;

    public Permissoes() {
    }

    public Permissoes(long idPermissoes, String descPermissoes) {
        super();
        this.idPermissoes = idPermissoes;
        this.descPermissoes = descPermissoes;
    }

    public Long getIdPermissoes() {
        return idPermissoes;
    }

    public void setIdPermissoes(Long idPermissoes) {
        this.idPermissoes = idPermissoes;
    }

    public String getDescPermissoes() {
        return descPermissoes;
    }

    public void setDescPermissoes(String descPermissoes) {
        this.descPermissoes = descPermissoes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
