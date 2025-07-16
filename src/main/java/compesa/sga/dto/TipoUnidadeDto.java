package compesa.sga.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoUnidadeDto {

  private int id;
  private String nome;
  private LocalDate dataRegistro;
  private String autor;
  private boolean disable;
  
}
