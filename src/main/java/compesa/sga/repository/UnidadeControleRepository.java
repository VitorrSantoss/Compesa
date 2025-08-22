package compesa.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import compesa.sga.model.UnidadeControle;

@Repository
public interface UnidadeControleRepository extends JpaRepository <UnidadeControle, Integer> {
 
}