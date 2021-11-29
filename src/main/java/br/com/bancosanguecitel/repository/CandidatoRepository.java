package br.com.bancosanguecitel.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bancosanguecitel.model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long>{

}
