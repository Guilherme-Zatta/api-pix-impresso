package br.senac.pr.api_pix_impresso.transacao.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import br.senac.pr.api_pix_impresso.shared.models.Transacao;
import br.senac.pr.api_pix_impresso.transacao.dtos.CreateTransacaoDto;

@Service
public class TransacaoToCreateTransacaoMapper implements Function<Transacao, CreateTransacaoDto> {

  @Override
  public CreateTransacaoDto apply(Transacao t) {
    return new CreateTransacaoDto(t.getCaixaId(),
        t.getContaId(),
        String.valueOf(t.getTipoTransacao()),
        t.getValor(),
        t.getLatitude(),
        t.getLongitude());
  }

}