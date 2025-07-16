package compesa.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import compesa.sga.model.TipoUnidade;

@Repository
public interface TipoUnidadeRepository extends JpaRepository <TipoUnidade, Integer> {

}

  

