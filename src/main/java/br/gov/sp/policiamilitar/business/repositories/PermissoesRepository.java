package br.gov.sp.policiamilitar.business.repositories;


import br.gov.sp.policiamilitar.business.entities.Permissoes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PermissoesRepository extends CrudRepository<Permissoes, Long> {

    public List<Permissoes> findByDescPermissoes(String descPermissao);

}
