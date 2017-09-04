package br.gov.sp.policiamilitar.business.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Escola implements Serializable{

    private static final long serialVersionUID = -1293538062275115697L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEscola;
    @Column(unique = true)
    Long codigoInep;
    @Column(unique = true)
    String codigoSeduc;
    @Column(unique = true)
    String nomeEscola;
    @Column(unique = true)
    String nomeEscolaInep;

    public Escola() {
    }

    public Escola(Long codigoInep, String codigoSeduc, String nomeEscola, String nomeEscolaInep) {
        this.codigoInep = codigoInep;
        this.codigoSeduc = codigoSeduc;
        this.nomeEscola = nomeEscola;
        this.nomeEscolaInep = nomeEscolaInep;
    }

    public String getNomeEscolaInep() {
        return nomeEscolaInep;
    }

    public void setNomeEscolaInep(String nomeEscolaInep) {
        this.nomeEscolaInep = nomeEscolaInep;
    }

    public Long getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(Long idEscola) {
        this.idEscola = idEscola;
    }

    public Long getCodigoInep() {
        return codigoInep;
    }

    public void setCodigoInep(Long codigoInep) {
        this.codigoInep = codigoInep;
    }

    public String getCodigoSeduc() {
        return codigoSeduc;
    }

    public void setCodigoSeduc(String codigoSeduc) {
        this.codigoSeduc = codigoSeduc;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }
}
