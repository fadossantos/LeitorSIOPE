package br.gov.sp.policiamilitar.business.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Competencia implements Serializable{

    private static final long serialVersionUID = -2842725125561354069L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCompetencia;
    int ano;
    int mes;
    @Column(unique = true)
    String descCompetencia;

    public Competencia(Long idCompetencia, int ano, int mes, String descCompetencia) {
        this.idCompetencia = idCompetencia;
        this.ano = ano;
        this.mes = mes;
        this.descCompetencia = descCompetencia;
    }

    public Competencia() {
    }

    public Long getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Long idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getDescCompetencia() {
        return descCompetencia;
    }

    public void setDescCompetencia(String descCompetencia) {
        this.descCompetencia = descCompetencia;
    }
}
