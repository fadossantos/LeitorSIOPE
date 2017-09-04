package br.gov.sp.policiamilitar.business.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cargo implements Serializable {


    private static final long serialVersionUID = -5983772399315019890L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCargo;
    @Column(unique = true)
    String descCargo;
    @ManyToOne
    @JoinTable(
            name = "Cargo_CargoSiope",
            joinColumns = @JoinColumn(name = "idCargo"),
            inverseJoinColumns = @JoinColumn(name = "idCargoSiope")
    )
    CargoSiope cargoSiope;

    public Cargo() {
    }

    public Cargo(Long idCargo, String descCargo, CargoSiope cargoSiope) {
        this.idCargo = idCargo;
        this.descCargo = descCargo;
        this.cargoSiope = cargoSiope;
    }

    public Cargo(String descCargo, CargoSiope cargoSiope) {
        this.descCargo = descCargo;
        this.cargoSiope = cargoSiope;
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public String getDescCargo() {
        return descCargo;
    }

    public void setDescCargo(String descCargo) {
        this.descCargo = descCargo;
    }

    public CargoSiope getCargoSiope() {
        return cargoSiope;
    }

    public void setCargoSiope(CargoSiope cargoSiope) {
        this.cargoSiope = cargoSiope;
    }
}
