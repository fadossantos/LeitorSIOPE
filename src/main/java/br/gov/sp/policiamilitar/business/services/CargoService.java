package br.gov.sp.policiamilitar.business.services;

import br.gov.sp.policiamilitar.business.entities.Cargo;
import br.gov.sp.policiamilitar.business.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;


    public CargoService() {
        super();
    }

    public Iterable<Cargo> findAll() {
        return this.cargoRepository.findAll();
    }

    public Cargo addOrUpdate(final Cargo cargo) {
        return this.cargoRepository.save(cargo);
    }

    public void remove(final Long id){
        this.cargoRepository.delete(id);
    }

    public Cargo findByDescCargo(String nomeCargo){
        List<Cargo> listCargo = this.cargoRepository.findByDescCargo(nomeCargo);
        if(listCargo.size() > 0)
            return listCargo.get(0);
        else return null;
    }

}
