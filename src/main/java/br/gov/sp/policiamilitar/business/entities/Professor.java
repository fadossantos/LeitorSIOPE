package br.gov.sp.policiamilitar.business.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Professor implements Serializable{

    private static final long serialVersionUID = -1579790901608224745L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProfessor;
    @Column(unique = true)
    String cpfProfessor;
    @Column(unique = true)
    String matricula;
    String nomeProfessor;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "Professor_Cargo",
            joinColumns = @JoinColumn(name = "idProfessor"),
            inverseJoinColumns = @JoinColumn(name = "idCargo")
    )
    Cargo cargo;
    @JsonBackReference
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Remuneracao> remuneracoes;

    public Professor() {
    }

    public Professor(Long idProfessor, String cpfProfessor, String matricula, String nomeProfessor, Cargo cargo, List<Remuneracao> remuneracoes) {
        this.idProfessor = idProfessor;
        this.cpfProfessor = cpfProfessor;
        this.matricula = matricula;
        this.nomeProfessor = nomeProfessor;
        this.cargo = cargo;
        this.remuneracoes = remuneracoes;

    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getCpfProfessor() {
        return cpfProfessor;
    }

    public void setCpfProfessor(String cpfProfessor) {
        this.cpfProfessor = cpfProfessor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Remuneracao> getRemuneracoes() {
        return remuneracoes;
    }

    public void setRemuneracoes(List<Remuneracao> remuneracoes) {
        this.remuneracoes = remuneracoes;
    }

}
