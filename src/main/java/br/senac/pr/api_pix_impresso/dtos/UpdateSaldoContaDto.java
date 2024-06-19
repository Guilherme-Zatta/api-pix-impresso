package br.senac.pr.api_pix_impresso.dtos;

public class UpdateSaldoContaDto {
  private Double saldo;

  public UpdateSaldoContaDto(Double saldo) {
    this.saldo = saldo;
  }

  public UpdateSaldoContaDto() {
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

}