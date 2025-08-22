package compesa.sga.model;

import java.time.LocalDate;

import compesa.sga.dto.TipoUnidadeDto;
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
@Entity(name = "tb_tipo_unidade")
public class TipoUnidade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull(message = "CAMPO {nome} OBRIGATÓRIO.")
  @Column(nullable = false)
  private String nome;

  @NotNull(message = "CAMPO {dataRegistro} OBRIGATÓRIO.")
  @Column(name = "data_registro", nullable = false)
  private LocalDate dataRegistro;

  @NotNull(message = "CAMPO {autor} OBRIGATÓRIO.")
  @Column
  private String autor;

  @NotNull(message = "CAMPO {disable} OBRIGATÓRIO.")
  @Column(nullable = false)
  private Boolean disable;
  
  public TipoUnidadeDto converterDto(){
    TipoUnidadeDto dto = new TipoUnidadeDto();

    dto.setId(id);
    dto.setNome(nome);
    dto.setDataRegistro(dataRegistro);
    dto.setAutor(autor);
    dto.setDisable(disable);

    return dto;
  }

}