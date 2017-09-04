package br.gov.sp.policiamilitar.business.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CargoSiope implements Serializable{


    private static final long serialVersionUID = 5378763078730799393L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCargoSiope;
    @Column(unique = true)
    String descCargoSiope;
    @ManyToOne
    @JoinTable(
            name = "CargoSiope_TipoCargoSiope",
            joinColumns = @JoinColumn(name = "idCargoSiope"),
            inverseJoinColumns = @JoinColumn(name = "idTipoCargoSiope")
    )
    TipoCargoSiope tipoCargoSiope;

    public CargoSiope() {
    }

    public CargoSiope(Long idCargoSiope, String descCargoSiope, TipoCargoSiope tipoCargoSiope) {
        this.idCargoSiope = idCargoSiope;
        this.descCargoSiope = descCargoSiope;
        this.tipoCargoSiope = tipoCargoSiope;
    }

    public CargoSiope(String descCargoSiope, TipoCargoSiope tipoCargoSiope) {
        this.descCargoSiope = descCargoSiope;
        this.tipoCargoSiope = tipoCargoSiope;
    }

    public Long getIdCargoSiope() {
        return idCargoSiope;
    }

    public void setIdCargoSiope(Long idCargoSiope) {
        this.idCargoSiope = idCargoSiope;
    }

    public String getDescCargoSiope() {
        return descCargoSiope;
    }

    public void setDescCargoSiope(String descCargoSiope) {
        this.descCargoSiope = descCargoSiope;
    }

    public TipoCargoSiope getTipoCargoSiope() {
        return tipoCargoSiope;
    }

    public void setTipoCargoSiope(TipoCargoSiope tipoCargoSiope) {
        this.tipoCargoSiope = tipoCargoSiope;
    }
}
