package br.gov.sp.policiamilitar.business.services;

import br.gov.sp.policiamilitar.business.entities.CargoSiope;
import br.gov.sp.policiamilitar.business.repositories.CargoSiopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CargoSiopeService {

    @Autowired
    private CargoSiopeRepository cargoSiopeRepository;


    public CargoSiopeService() {
        super();
    }

    public Iterable<CargoSiope> findAll() {
        return this.cargoSiopeRepository.findAll();
    }

    public CargoSiope findOne(Long idCargoSiope){return this.cargoSiopeRepository.findOne(idCargoSiope);}

    public CargoSiope addOrUpdate(final CargoSiope cargoSiope) {
        return this.cargoSiopeRepository.save(cargoSiope);
    }

    public void remove(final Long id){
        this.cargoSiopeRepository.delete(id);
    }

    public CargoSiope findByDescCargoSiope(String nomeCargoSiope){
        List<CargoSiope> listCargoSiope = this.cargoSiopeRepository.findByDescCargoSiope(nomeCargoSiope);
        if(listCargoSiope.size() > 0)
            return listCargoSiope.get(0);
        else return null;
    }

}
