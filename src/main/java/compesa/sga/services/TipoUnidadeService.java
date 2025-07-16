package compesa.sga.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import compesa.sga.dto.TipoUnidadeDto;
import compesa.sga.model.TipoUnidade;
import compesa.sga.repository.TipoUnidadeRepository;

@Service
public class TipoUnidadeService {

  @Autowired
  private TipoUnidadeRepository tipoUnidadeRepository;


  public List<TipoUnidadeDto> GetAllTipoUnidadeService(){
    
    List<TipoUnidade> tiposUnidade = tipoUnidadeRepository.findAll();

    List<TipoUnidadeDto> dtos = new ArrayList<>();

    for(TipoUnidade tipoUnidade : tiposUnidade){
      dtos.add(tipoUnidade.converterDto());
    }

    return dtos;
  }


  public TipoUnidadeDto GetTipoUnidadeById(int id){
    Optional<TipoUnidade> tipoUnidadeOpt = tipoUnidadeRepository.findById(id);

    if (tipoUnidadeOpt.isPresent()){
      TipoUnidade tipoUnidade = tipoUnidadeOpt.get();
      return tipoUnidade.converterDto();
    }
    return null;
  }


  public void DeleteTipoUnidade(int id){
    tipoUnidadeRepository.deleteById(id);
  }
  

  public TipoUnidade SaveTipoUnidade(TipoUnidade tipoUnidade){
    return tipoUnidadeRepository.save(tipoUnidade);
  }


}