package compesa.sga.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import compesa.sga.dto.UnidadeControleDto;
import compesa.sga.model.UnidadeControle;
import compesa.sga.repository.UnidadeControleRepository;

@Service
public class UnidadeControleService {

  @Autowired
  private UnidadeControleRepository unidadeControleRepository;

  public List<UnidadeControleDto> GetAllUnidadeControle() {

    List<UnidadeControle> unidadesControle = unidadeControleRepository.findAll();

    List<UnidadeControleDto> dtos = new ArrayList<>();

    for (UnidadeControle unidadeControle : unidadesControle) {
      dtos.add(unidadeControle.converterParaDto());
    }

    return dtos;
  }

  public UnidadeControleDto GetUnidadeControleById(int id) {

    Optional<UnidadeControle> unidadeControleOpt = unidadeControleRepository.findById(id);

    if (unidadeControleOpt.isPresent()){
      UnidadeControle unidadeControle = unidadeControleOpt.get();
      return unidadeControle.converterParaDto();  
    }
    return null;
  }


  public void DeleteUnidadeControle(int id){
    unidadeControleRepository.deleteById(id);  
  }


  public UnidadeControle SaveUnidadeControle(UnidadeControle unidadeControle){
    return unidadeControleRepository.save(unidadeControle);
  }

}