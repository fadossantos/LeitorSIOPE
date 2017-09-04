package br.gov.sp.policiamilitar.business.repositories;

import br.gov.sp.policiamilitar.business.entities.Conta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContaRepository extends CrudRepository<Conta, Long> {
    public List<Conta> findByUsername(String login);
}
