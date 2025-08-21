package compesa.sga.model;

import java.time.LocalDate;

import compesa.sga.dto.UnidadeControleDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_unidade_controle")
public class UnidadeControle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull(message = "CAMPO {nome} OBRIGATÓRIO.") // NOT NULL -> REQUISIÃO
  @Column(nullable = false) // NOT NULL -> BANCO DE DADOS
  private String nome;
  
  @ManyToOne
  @JoinColumn(name = "tipo_controle_id")
  private TipoControle tipoControleId;

  @NotNull(message = "CAMPO {disable} OBRIGATÓRIO.")
  @Column(nullable = false)
  private Boolean disable;

  @NotNull(message = "CAMPO {vigencia} OBRIGATÓRIO.")
  @Column(nullable = false)
  private LocalDate vigencia;

  @NotNull(message = "CAMPO {autor} OBRIGATÓRIO.")
  @Column(nullable = false)
  private String autor;

  @NotNull(message = "CAMPO {ultimaAtualizacao} OBRIGATÓRIO.")
  @Column(name = "ultima_atualização", nullable = false)
  private LocalDate ultimaAtualizacao;

  public UnidadeControleDto converterParaDto() {
    UnidadeControleDto dto = new UnidadeControleDto();

    dto.setId(id);
    dto.setNome(nome);
    dto.setTipoControleId(tipoControleId);
    dto.setDisable(disable);
    dto.setVigencia(vigencia);
    dto.setAutor(autor);
    dto.setUltimaAtualizacao(ultimaAtualizacao);

    return dto;
  }
}