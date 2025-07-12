package compesa.sga.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import compesa.sga.dto.UnidadeControleDto;
import compesa.sga.model.UnidadeControle;
import compesa.sga.services.UnidadeControleService;

@RestController
@RequestMapping("/unidadeControle")
public class UnidadeControleController {

  @Autowired
  private UnidadeControleService unidadeControleService;

  // 1º EndPoint
  @GetMapping
  public ResponseEntity<List<UnidadeControleDto>> GetUnidadeControle() {
    return ResponseEntity.ok().body(unidadeControleService.GetAllUnidadeControle());
  }

  // 2º EndPoint
  @GetMapping("/{id}")
  public ResponseEntity<UnidadeControleDto> GetById(@PathVariable("id") int id) {
    UnidadeControleDto unidadeControle = unidadeControleService.GetUnidadeControleById(id);

    if (Objects.isNull(unidadeControle)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(unidadeControle);
  }

  // 4º EndPoint
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> DeleteUnidadeControle(@PathVariable("id") int id) {
    UnidadeControleDto unControleDto = unidadeControleService.GetUnidadeControleById(id);

    if (Objects.isNull(unControleDto)) {
      return ResponseEntity.notFound().build();
    }

    unidadeControleService.DeleteUnidadeControle(id);

    return ResponseEntity.noContent().build();
  }

  // 4º EndPoint
  @PostMapping
  public ResponseEntity<UnidadeControle> PostUnidadeControle(@RequestBody UnidadeControle unidadeControle) {
    return ResponseEntity.status(HttpStatus.CREATED).body(unidadeControleService.SaveUnidadeControle(unidadeControle));
  }

  @PutMapping("/{id}")
  public ResponseEntity<UnidadeControle> PutUnidadeControle(@PathVariable("id") int id, @RequestBody UnidadeControle unidadeControle){
    UnidadeControleDto  uniControle = unidadeControleService.GetUnidadeControleById(id);

    if (Objects.isNull(uniControle)){
      return ResponseEntity.noContent().build();
    }

    unidadeControle.setId(id);

    return ResponseEntity.ok().body(unidadeControleService.SaveUnidadeControle(unidadeControle));

  }

}