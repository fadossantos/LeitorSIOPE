package br.gov.sp.policiamilitar.business.services;

import br.gov.sp.policiamilitar.business.entities.Escola;
import br.gov.sp.policiamilitar.business.repositories.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;


    public EscolaService() {
        super();
    }

    public Iterable<Escola> findAll() {
        return this.escolaRepository.findAll();
    }

    public Escola addOrUpdate(final Escola escola) {
        return this.escolaRepository.save(escola);
    }

    public void remove(final Long id){
        this.escolaRepository.delete(id);
    }

    public Escola findByNomeEscola(String nomeEscola){
        List<Escola> listEscola = this.escolaRepository.findByNomeEscola(nomeEscola);
        if(listEscola.size() > 0)
            return listEscola.get(0);
        else return null;
    }

    public Escola findByNomeEscolaInep(String nomeEscolaInep){
        List<Escola> listEscola = this.escolaRepository.findByNomeEscolaInep(nomeEscolaInep);
        if(listEscola.size() > 0)
            return listEscola.get(0);
        else return null;
    }

}
