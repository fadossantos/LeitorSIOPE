package br.gov.sp.policiamilitar.business.repositories;


import br.gov.sp.policiamilitar.business.entities.CargoSiope;
import br.gov.sp.policiamilitar.business.entities.Escola;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CargoSiopeRepository extends CrudRepository<CargoSiope, Long> {

    public List<CargoSiope> findByDescCargoSiope(String descCargoSiope);

}
