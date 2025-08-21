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

  public List<TipoControleDto> getAllTipoControleService() {

    List<TipoControle> tiposControle = tipoControleRepository.findAll();

    List<TipoControleDto> dtos = new ArrayList<>();

    for (TipoControle tipoControle : tiposControle) {
      dtos.add(tipoControle.converterParaDto());
    }

    return dtos;
  }

  public TipoControleDto getTipoControleById(int id) {

    Optional<TipoControle> tipoControleOpt = tipoControleRepository.findById(id);

    if (tipoControleOpt.isPresent()) {
      TipoControle tipoControle = tipoControleOpt.get();
      return tipoControle.converterParaDto();
    }
    return null;
  }

  public void deleteTipoControle(int id) {
    tipoControleRepository.deleteById(id);
  }

  public TipoControle saveTipoControle(TipoControle tipoControle) {
    return tipoControleRepository.save(tipoControle);
  }

  public TipoControle updateParcial(int id, TipoControle atualizacao) {
    Optional<TipoControle> tipoControleAtual = tipoControleRepository.findById(id);

    // Verificação se o container (optional) possui o objeto "TipoControle"
    if (tipoControleAtual.isPresent()) {
      TipoControle tipoControle = tipoControleAtual.get();

      // Aplicação dos campos que foram fornecidos no JSON (postman/swagger)
      if (atualizacao.getNome() != null) {
        tipoControle.setNome(atualizacao.getNome());
      }

      return tipoControleRepository.save(tipoControle);
    } 
    else {
      throw new RuntimeException("TipoControle não encontrado com id: " + id);
    }
  }

}