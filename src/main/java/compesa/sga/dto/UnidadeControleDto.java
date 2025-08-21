package compesa.sga.dto;

import java.time.LocalDate;

import compesa.sga.model.TipoControle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeControleDto {

  private int id;
  private String nome;
  private TipoControle tipoControleId;
  private Boolean disable;
  private LocalDate vigencia;
  private String autor;
  private LocalDate ultimaAtualizacao;

}
