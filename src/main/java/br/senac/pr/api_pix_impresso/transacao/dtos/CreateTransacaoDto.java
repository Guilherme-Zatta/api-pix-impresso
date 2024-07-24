package br.senac.pr.api_pix_impresso.transacao.dtos;

public record CreateTransacaoDto(
    Long caixaId,
    Long contaId,
    String tipoTransacao,
    Double valor,
    Double latitude,
    Double longitude) {

}