package br.gov.sp.policiamilitar.business.repositories;


import br.gov.sp.policiamilitar.business.entities.Escola;
import br.gov.sp.policiamilitar.business.entities.Permissoes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EscolaRepository extends CrudRepository<Escola, Long> {

    public List<Escola> findByNomeEscola(String nomeEscola);
    public List<Escola> findByNomeEscolaInep(String nomeEscolaInep);

}
