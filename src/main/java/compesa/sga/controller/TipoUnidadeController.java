package compesa.sga.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import compesa.sga.dto.TipoUnidadeDto;
import compesa.sga.model.TipoUnidade;
import compesa.sga.services.TipoUnidadeService;

@RestController
@RequestMapping("/tipoUnidade")
public class TipoUnidadeController {

  @Autowired
  private TipoUnidadeService tipoUnidadeService;

  // 1º ENDPOINT
  @GetMapping
  public ResponseEntity<List<TipoUnidadeDto>> GetAllTipoUnidade() {
    return ResponseEntity.ok().body(tipoUnidadeService.getAllTipoUnidadeService());
  }

  // 2º ENDPOINT
  @GetMapping("/{id}")
  public ResponseEntity<TipoUnidadeDto> GetByIdTipoUnidade(@PathVariable("id") int id) {
    TipoUnidadeDto tipoUnidade = tipoUnidadeService.getTipoUnidadeById(id);

    if (Objects.isNull(tipoUnidade)) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().body(tipoUnidade);

  }

  // 3º ENDPOINT
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> DeleteTipoUnidade(@PathVariable("id") int id) {
    TipoUnidadeDto tUnidadeDto = tipoUnidadeService.getTipoUnidadeById(id);

    if (Objects.isNull(tUnidadeDto)) {
      return ResponseEntity.notFound().build();
    }
    tipoUnidadeService.deleteTipoUnidade(id);

    return ResponseEntity.noContent().build();
  }

  // 4º ENDPOINT
  @PostMapping
  public ResponseEntity<TipoUnidade> PostTipoUnidade(@RequestBody TipoUnidade tipoUnidade) {
    return ResponseEntity.status(HttpStatus.CREATED).body(tipoUnidadeService.saveTipoUnidade(tipoUnidade));
  }

  // 5º ENDPOINT
  @PutMapping("/{id}")
  public ResponseEntity<TipoUnidade> PutTipoUnidade(@PathVariable("id") int id, @RequestBody TipoUnidade tipoUnidade) {
    TipoUnidadeDto tDto = tipoUnidadeService.getTipoUnidadeById(id);

    if (Objects.isNull(tDto)) {
      return ResponseEntity.noContent().build();
    }
    tipoUnidade.setId(id);

    return ResponseEntity.ok().body(tipoUnidadeService.saveTipoUnidade(tipoUnidade));
  }

  // 6º ENDPOINT
  @PatchMapping("/{id}")
  public ResponseEntity<TipoUnidade> atualizarTipoUnidadeParcialmente(@PathVariable int id, @RequestBody TipoUnidade atualizacao) {
    TipoUnidade dadosAtualizado = tipoUnidadeService.updateParcial(id, atualizacao);

    return ResponseEntity.ok(dadosAtualizado);
  }

}