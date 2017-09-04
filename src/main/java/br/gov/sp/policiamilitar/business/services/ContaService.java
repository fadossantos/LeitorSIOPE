package br.gov.sp.policiamilitar.business.services;

import br.gov.sp.policiamilitar.business.entities.Conta;
import br.gov.sp.policiamilitar.business.entities.Permissoes;
import br.gov.sp.policiamilitar.business.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class ContaService implements  UserDetailsService{

    @Autowired
    private ContaRepository contaRepository;

    public ContaService() {
        super();
    }

    public Iterable<Conta> findAll() {
        return this.contaRepository.findAll();
    }

    public Conta findbyLogin(String conta) {

        List<Conta> listConta = this.contaRepository.findByUsername(conta);
        if(listConta.size() > 0)
            return listConta.get(0);
        else return null;
    }

    public void addOrUpdate(final Conta conta) {
        this.contaRepository.save(conta);
    }

    public void remove(final String conta) {
        Conta contaTemp = this.findbyLogin(conta);
        this.contaRepository.delete(contaTemp);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Conta conta = this.findbyLogin(username);
        if (conta != null) {
            UserDetails userDetails = new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    Iterable<Permissoes> listaPermissoes = conta.getPermissoes();
                    List<GrantedAuthority> grantedAuths = new ArrayList<>();
                    for (Permissoes perm : listaPermissoes) {
                        grantedAuths.add(new SimpleGrantedAuthority(perm.getDescPermissoes()));
                    }
                    return grantedAuths;
                }

                @Override
                public String getPassword() {
                    return conta.getPassword();
                }

                @Override
                public String getUsername() {
                    return conta.getUsername();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };
            return userDetails;
        } else throw new UsernameNotFoundException(username);
    }
}
