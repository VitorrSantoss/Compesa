package compesa.sga.model;

import compesa.sga.dto.TipoControleDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_tipo_controle")
public class TipoControle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull(message = "CAMPO {nome} OBRIGATÓRIO.")
  @Column(nullable = false)
  private String nome;

  public TipoControleDto converterParaDto() {
    TipoControleDto dto = new TipoControleDto();

    dto.setId(id);
    dto.setNome(nome);

    return dto;
  }
}