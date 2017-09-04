package br.gov.sp.policiamilitar.business.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;



@Entity
@NamedQuery(name = "Conta.findAll", query = "SELECT i FROM Conta i")
public class Conta implements Serializable{

    private static final long serialVersionUID = -1091552546980132718L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;
    private boolean ativo;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Permissoes> permissoes;

    public Conta() {
    }

    public Conta(Long idConta, boolean ativo, String username, String password, List<Permissoes> permissoes) {
        this.idConta = idConta;
        this.ativo = ativo;
        this.username = username;
        this.password = password;
        this.permissoes = permissoes;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Permissoes> getPermissoes() {
        if (permissoes != null) {
            return permissoes;
        } else {
            return new ArrayList<Permissoes>();
        }
    }

    public void setPermissoes(List<Permissoes> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
