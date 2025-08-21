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

  public List<UnidadeControleDto> getAllUnidadeControle() {

    List<UnidadeControle> unidadesControle = unidadeControleRepository.findAll();

    List<UnidadeControleDto> dtos = new ArrayList<>();

    for (UnidadeControle unidadeControle : unidadesControle) {
      dtos.add(unidadeControle.converterParaDto());
    }

    return dtos;
  }

  public UnidadeControleDto getUnidadeControleById(int id) {

    Optional<UnidadeControle> unidadeControleOpt = unidadeControleRepository.findById(id);

    if (unidadeControleOpt.isPresent()){
      UnidadeControle unidadeControle = unidadeControleOpt.get();
      return unidadeControle.converterParaDto();  
    }
    return null;
  }

  public void deleteUnidadeControle(int id){
    unidadeControleRepository.deleteById(id);  
  }

  public UnidadeControle saveUnidadeControle(UnidadeControle unidadeControle){
    return unidadeControleRepository.save(unidadeControle);
  }

  public UnidadeControle uptadeParcial(int id, UnidadeControle atualizacao){
    Optional<UnidadeControle> unidadeControleAtual = unidadeControleRepository.findById(id);

    // Verificação se o container (optional) possui o objeto "UnidadeControle"
    if (unidadeControleAtual.isPresent()){
      UnidadeControle unidadeControle = unidadeControleAtual.get();

      // Aplicação dos campos que foram fornecidos no JSON (postman/swagger)
      if (atualizacao.getNome() != null){
        unidadeControle.setNome(atualizacao.getNome());
      }

      if (atualizacao.getTipoControleId() != null){
        unidadeControle.setTipoControleId(atualizacao.getTipoControleId());
      }

      if (atualizacao.getVigencia() != null){
        unidadeControle.setVigencia(atualizacao.getVigencia());
      }

      if (atualizacao.getAutor() != null){
        unidadeControle.setAutor(atualizacao.getAutor());
      }

      if (atualizacao.getUltimaAtualizacao() != null) {
        unidadeControle.setUltimaAtualizacao(atualizacao.getUltimaAtualizacao());
      }

      if (atualizacao.getDisable() != null){
        unidadeControle.setDisable(atualizacao.getDisable());
      }

      return unidadeControleRepository.save(unidadeControle);
    }
    else{
      throw new RuntimeException("UnidadeControle não encontrado com id " + id);
    }
  }

}