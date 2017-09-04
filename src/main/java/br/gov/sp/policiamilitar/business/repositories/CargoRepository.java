package br.gov.sp.policiamilitar.business.repositories;


import br.gov.sp.policiamilitar.business.entities.Cargo;
import br.gov.sp.policiamilitar.business.entities.CargoSiope;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CargoRepository extends CrudRepository<Cargo, Long> {

    public List<Cargo> findByDescCargo(String descCargo);

}
