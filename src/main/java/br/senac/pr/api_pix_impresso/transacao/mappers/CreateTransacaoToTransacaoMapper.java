package br.senac.pr.api_pix_impresso.transacao.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import br.senac.pr.api_pix_impresso.shared.models.Transacao;
import br.senac.pr.api_pix_impresso.transacao.dtos.CreateTransacaoDto;

@Service
public class CreateTransacaoToTransacaoMapper implements Function<CreateTransacaoDto, Transacao> {

  @Override
  public Transacao apply(CreateTransacaoDto t) {
    return new Transacao(
        t.caixaId(),
        t.contaId(),
        t.tipoTransacao().charAt(0),
        t.valor(),
        null,
        t.latitude(),
        t.longitude());
  }

}