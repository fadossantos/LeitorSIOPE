package br.gov.sp.policiamilitar.business.services;

import br.gov.sp.policiamilitar.business.entities.Permissoes;
import br.gov.sp.policiamilitar.business.repositories.PermissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PermissoesService {

    @Autowired
    private PermissoesRepository permissoesRepository;


    public PermissoesService() {
        super();
    }

    public Iterable<Permissoes> findAll() {
        return this.permissoesRepository.findAll();
    }

    public Permissoes addOrUpdate(final Permissoes permissoes) {
        return this.permissoesRepository.save(permissoes);
    }

    public void remove(final Long id){
        this.permissoesRepository.delete(id);
    }

    public Permissoes findByDescPermissoes(String descPermissoes){
        List<Permissoes> listPermissoes = this.permissoesRepository.findByDescPermissoes(descPermissoes);
        if(listPermissoes.size() > 0)
            return listPermissoes.get(0);
        else return null;
    }

}
