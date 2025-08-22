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

import compesa.sga.dto.TipoControleDto;
import compesa.sga.model.TipoControle;
import compesa.sga.services.TipoControleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipoControle")
public class TipoControleController {

  @Autowired
  private TipoControleService tipoControleService;

  // 1º ENDPOINT
  @GetMapping
  public ResponseEntity<List<TipoControleDto>> getTipoControle() {
    return ResponseEntity.ok().body(tipoControleService.getAllTipoControleService());
  }

  // 2º ENDPOINT
  @GetMapping("/{id}")
  public ResponseEntity<TipoControleDto> getById(@PathVariable("id") int id) {
    TipoControleDto tipoControle = tipoControleService.getTipoControleById(id);

    if (Objects.isNull(tipoControle)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(tipoControle);
  }

  // 3º ENDPOINT
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTipoControle(@PathVariable("id") int id) {
    TipoControleDto tControleDto = tipoControleService.getTipoControleById(id);

    if (Objects.isNull(tControleDto)) {
      return ResponseEntity.notFound().build();
    }
    tipoControleService.deleteTipoControle(id);

    return ResponseEntity.noContent().build();

  }

  // 4º ENDPOINT
  @PostMapping
  public ResponseEntity<TipoControle> PostTipoControle(@Valid @RequestBody TipoControle tipoControle) {
    return ResponseEntity.status(HttpStatus.CREATED).body(tipoControleService.saveTipoControle(tipoControle));
  }

  // 5º ENDPOINT
  @PutMapping("/{id}")
  public ResponseEntity<TipoControle> PutTipoControle(@PathVariable("id") int id, @RequestBody TipoControle tipoControle) {
    TipoControleDto tControleDto = tipoControleService.getTipoControleById(id);
    if (Objects.isNull(tControleDto)) {
      return ResponseEntity.noContent().build();
    }
    tipoControle.setId(id);

    return ResponseEntity.ok().body(tipoControleService.saveTipoControle(tipoControle));
  }

  // 6º ENDPOINT
  @PatchMapping("/{id}")
  public ResponseEntity<TipoControle> atualizarTipoControleParcialmente(@PathVariable int id, @RequestBody TipoControle atualizacao) {
    TipoControle dadosAtualizado = tipoControleService.updateParcial(id, atualizacao);
    
    return ResponseEntity.ok(dadosAtualizado);
  }

}