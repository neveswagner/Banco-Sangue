package br.com.bancosanguecitel.repository;
import br.com.bancosanguecitel.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Long> {

}
