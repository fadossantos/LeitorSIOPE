package br.gov.sp.policiamilitar.business.services;

import br.gov.sp.policiamilitar.business.entities.TipoCargoSiope;
import br.gov.sp.policiamilitar.business.repositories.TipoCargoSiopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TipoCargoSiopeService {

    @Autowired
    private TipoCargoSiopeRepository tipoCargoSiopeRepository;


    public TipoCargoSiopeService() {
        super();
    }

    public TipoCargoSiope findOne(Long idTipoCargoSiope){
        return this.tipoCargoSiopeRepository.findOne(idTipoCargoSiope);
    }

    public Iterable<TipoCargoSiope> findAll() {
        return this.tipoCargoSiopeRepository.findAll();
    }

    public TipoCargoSiope addOrUpdate(final TipoCargoSiope tipoCargoSiope) {
        return this.tipoCargoSiopeRepository.save(tipoCargoSiope);
    }

    public void remove(final Long id){
        this.tipoCargoSiopeRepository.delete(id);
    }

}
