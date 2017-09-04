package br.gov.sp.policiamilitar.business.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Remuneracao implements Serializable{


    private static final long serialVersionUID = 7846464439212264833L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRemuneracao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Remuneracao_Competencia",
            joinColumns = @JoinColumn(name = "idRemuneracao"),
            inverseJoinColumns = @JoinColumn(name = "idCompetencia")
    )
    Competencia competencia;
    BigDecimal salarioBase;
    BigDecimal salarioBruto;
    BigDecimal auxilioAlimentacao;
    BigDecimal semAuxilioAlimentacao;
    BigDecimal IPR;
    BigDecimal CAPEP;
    BigDecimal INSS;
    BigDecimal FGTS;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "idProfessor")
    Professor professor;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "idEscola")
    Escola escola;

    public Remuneracao() {
    }

    public Remuneracao(Long idRemuneracao,Escola escola, Competencia competencia, BigDecimal salarioBase, BigDecimal salarioBruto, BigDecimal auxilioAlimentacao, BigDecimal semAuxilioAlimentacao, BigDecimal IPR, BigDecimal CAPEP, BigDecimal INSS, BigDecimal FGTS, Professor professor) {
        this.idRemuneracao = idRemuneracao;
        this.escola = escola;
        this.competencia = competencia;
        this.salarioBase = salarioBase;
        this.salarioBruto = salarioBruto;
        this.auxilioAlimentacao = auxilioAlimentacao;
        this.semAuxilioAlimentacao = semAuxilioAlimentacao;
        this.IPR = IPR;
        this.CAPEP = CAPEP;
        this.INSS = INSS;
        this.FGTS = FGTS;
        this.professor = professor;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public Long getIdRemuneracao() {
        return idRemuneracao;
    }

    public void setIdRemuneracao(Long idRemuneracao) {
        this.idRemuneracao = idRemuneracao;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public BigDecimal getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(BigDecimal salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public BigDecimal getAuxilioAlimentacao() {
        return auxilioAlimentacao;
    }

    public void setAuxilioAlimentacao(BigDecimal auxilioAlimentacao) {
        this.auxilioAlimentacao = auxilioAlimentacao;
    }

    public BigDecimal getSemAuxilioAlimentacao() {
        return semAuxilioAlimentacao;
    }

    public void setSemAuxilioAlimentacao(BigDecimal semAuxilioAlimentacao) {
        this.semAuxilioAlimentacao = semAuxilioAlimentacao;
    }

    public BigDecimal getIPR() {
        return IPR;
    }

    public void setIPR(BigDecimal IPR) {
        this.IPR = IPR;
    }

    public BigDecimal getCAPEP() {
        return CAPEP;
    }

    public void setCAPEP(BigDecimal CAPEP) {
        this.CAPEP = CAPEP;
    }

    public BigDecimal getINSS() {
        return INSS;
    }

    public void setINSS(BigDecimal INSS) {
        this.INSS = INSS;
    }

    public BigDecimal getFGTS() {
        return FGTS;
    }

    public void setFGTS(BigDecimal FGTS) {
        this.FGTS = FGTS;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
