package br.gov.sp.policiamilitar.business.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoCargoSiope {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idTipoCargoSiope;
    String descTipoCargoSiope;

    public TipoCargoSiope() {
    }

    public TipoCargoSiope(Long idTipoCargoSiope, String descTipoCargoSiope) {
        this.idTipoCargoSiope = idTipoCargoSiope;
        this.descTipoCargoSiope = descTipoCargoSiope;
    }

    public TipoCargoSiope(String descTipoCargoSiope) {
        this.descTipoCargoSiope = descTipoCargoSiope;
    }

    public Long getIdTipoCargoSiope() {
        return idTipoCargoSiope;
    }

    public void setIdTipoCargoSiope(Long idTipoCargoSiope) {
        this.idTipoCargoSiope = idTipoCargoSiope;
    }

    public String getDescTipoCargoSiope() {
        return descTipoCargoSiope;
    }

    public void setDescTipoCargoSiope(String descTipoCargoSiope) {
        this.descTipoCargoSiope = descTipoCargoSiope;
    }
}
