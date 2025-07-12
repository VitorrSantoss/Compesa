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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import compesa.sga.dto.TipoControleDto;
import compesa.sga.model.TipoControle;
import compesa.sga.services.TipoControleService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipoControle")
public class TipoControleController {
  
  @Autowired
  private TipoControleService tipoControleService;

  // 1º EndPoint
  @GetMapping
  public ResponseEntity<List<TipoControleDto>> GetTipoControle(){
    return ResponseEntity.ok().body(tipoControleService.GetAllTipoControleService());
  }

  // 2º EndPoint
  @GetMapping("/{id}")
  public ResponseEntity<TipoControleDto> GetById(@PathVariable("id") int id){
    TipoControleDto tipoControle = tipoControleService.GetTipoControleById(id);

    if (Objects.isNull(tipoControle)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(tipoControle);
  }

  // 3º EndPoint
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> DeleteTipoControle(@PathVariable("id") int id){
    TipoControleDto tControleDto = tipoControleService.GetTipoControleById(id);

    if (Objects.isNull(tControleDto)){
      return ResponseEntity.notFound().build();
    }

    tipoControleService.DeleteTipoControle(id);

    return ResponseEntity.noContent().build();

  }

  
  // 4º EndPoint
  @PostMapping
  public ResponseEntity<TipoControle> PostTipoControle(@Valid @RequestBody TipoControle tipoControle){
    return ResponseEntity.status(HttpStatus.CREATED).body(tipoControleService.SaveTipoControle(tipoControle));
  }

  @PutMapping("/{id}")
  public ResponseEntity<TipoControle> PutTipoControle(@PathVariable("id") int id, @RequestBody TipoControle tipoControle){
    TipoControleDto tControleDto = tipoControleService.GetTipoControleById(id);
    if (Objects.isNull(tControleDto)){
      return ResponseEntity.noContent().build();
    }

    tipoControle.setId(id);

    return ResponseEntity.ok().body(tipoControleService.SaveTipoControle(tipoControle));
  }



}