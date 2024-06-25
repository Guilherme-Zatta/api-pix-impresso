package br.senac.pr.api_pix_impresso.transacao;

import java.util.List;

import br.senac.pr.api_pix_impresso.models.Transacao;
import br.senac.pr.api_pix_impresso.transacao.dtos.CreateTransacaoDto;

public interface TransacaoService {
  public Transacao save(CreateTransacaoDto dto);

  public List<Transacao> findAll();

  public Transacao findById(Long id);

  public void deleteById(Long id);
}