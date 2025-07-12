package compesa.sga.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import compesa.sga.dto.TipoControleDto;
import compesa.sga.model.TipoControle;
import compesa.sga.repository.TipoControleRepository;

@Service
public class TipoControleService { 

  @Autowired
  private TipoControleRepository tipoControleRepository;

  public List<TipoControleDto> GetAllTipoControleService(){

    List<TipoControle> tiposControle = tipoControleRepository.findAll();

    List<TipoControleDto> dtos = new ArrayList<>();

    for (TipoControle tipoControle : tiposControle){
      dtos.add(tipoControle.converterParaDto());
    }

    return dtos;
  }

  public TipoControleDto GetTipoControleById(int id){
    
    Optional<TipoControle> tipoControleOpt = tipoControleRepository.findById(id);

    if (tipoControleOpt.isPresent()) {
      TipoControle tipoControle = tipoControleOpt.get();
      return tipoControle.converterParaDto();
    }
    return null;
  }
  

  public void DeleteTipoControle(int id){
    tipoControleRepository.deleteById(id);
  }

  public TipoControle SaveTipoControle(TipoControle tipoControle){
    return tipoControleRepository.save(tipoControle);
  }


}
