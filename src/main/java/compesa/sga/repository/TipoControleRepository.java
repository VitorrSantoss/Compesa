package compesa.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import compesa.sga.model.TipoControle;

@Repository
public interface TipoControleRepository extends JpaRepository <TipoControle, Integer>{
  
}
