package br.senac.pr.api_pix_impresso.shared.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "transacoes")
public class Transacao {
  @Id
  private Long id;
  private Long caixaId;
  private Long contaId;
  private LocalDateTime dataHora;
  private char tipoTransacao;
  private Double valor;
  private Double latitude;
  private Double longitude;

  public Transacao(Long caixaId, Long contaId,
      char tipoTransacao, Double valor,
      LocalDateTime dataHora,
      Double latitude,
      Double longitude) {
    this.caixaId = caixaId;
    this.contaId = contaId;
    this.dataHora = dataHora;
    this.tipoTransacao = tipoTransacao;
    this.valor = valor;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCaixaId() {
    return caixaId;
  }

  public void setCaixaId(Long caixaId) {
    this.caixaId = caixaId;
  }

  public Long getContaId() {
    return contaId;
  }

  public void setContaId(Long contaId) {
    this.contaId = contaId;
  }

  public LocalDateTime getDataHora() {
    return dataHora;
  }

  public void setDataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
  }

  public char getTipoTransacao() {
    return tipoTransacao;
  }

  public void setTipoTransacao(char tipoTransacao) {
    this.tipoTransacao = tipoTransacao;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

}