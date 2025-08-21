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

  public List<TipoUnidadeDto> getAllTipoUnidadeService() {

    List<TipoUnidade> tiposUnidade = tipoUnidadeRepository.findAll();

    List<TipoUnidadeDto> dtos = new ArrayList<>();

    for (TipoUnidade tipoUnidade : tiposUnidade) {
      dtos.add(tipoUnidade.converterDto());
    }

    return dtos;
  }

  public TipoUnidadeDto getTipoUnidadeById(int id) {
    Optional<TipoUnidade> tipoUnidadeOpt = tipoUnidadeRepository.findById(id);

    if (tipoUnidadeOpt.isPresent()) {
      TipoUnidade tipoUnidade = tipoUnidadeOpt.get();
      return tipoUnidade.converterDto();
    }
    return null;
  }

  public void deleteTipoUnidade(int id) {
    tipoUnidadeRepository.deleteById(id);
  }

  public TipoUnidade saveTipoUnidade(TipoUnidade tipoUnidade) {
    return tipoUnidadeRepository.save(tipoUnidade);
  }

  public TipoUnidade updateParcial(int id, TipoUnidade atualizacao) {
    Optional<TipoUnidade> tipoUnidadeAtual = tipoUnidadeRepository.findById(id);

    // Verificando se o container (optional) possui o objeto "TipoUnidade"
    if (tipoUnidadeAtual.isPresent()) {
      TipoUnidade tipoUnidade = tipoUnidadeAtual.get();

      // Aplicação dos campos que foram fornecidos no JSON (postman/swagger)
      if (atualizacao.getNome() != null) {
        tipoUnidade.setNome(atualizacao.getNome());
      }

      if (atualizacao.getDataRegistro() != null) {
        tipoUnidade.setDataRegistro(atualizacao.getDataRegistro());
      }

      if (atualizacao.getAutor() != null) {
        tipoUnidade.setAutor(atualizacao.getAutor());
      }

      if (atualizacao.getDisable() != null) {
        tipoUnidade.setDisable(atualizacao.getDisable());
      }

      return tipoUnidadeRepository.save(tipoUnidade);
    } else {
      throw new RuntimeException("TipoUnidade não encontrado com id: " + id);
    }

  }

}