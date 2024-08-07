package br.senac.pr.api_pix_impresso.transacao.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.senac.pr.api_pix_impresso.shared.models.Transacao;
import br.senac.pr.api_pix_impresso.transacao.TransacaoRepository;
import br.senac.pr.api_pix_impresso.transacao.TransacaoService;
import br.senac.pr.api_pix_impresso.transacao.dtos.CreateTransacaoDto;
import br.senac.pr.api_pix_impresso.transacao.dtos.UpdateValorDto;

@Service
public class TransacaoServiceImpl implements TransacaoService {
  private final TransacaoRepository transacaoRepository;

  public TransacaoServiceImpl(TransacaoRepository transacaoRepository) {
    this.transacaoRepository = transacaoRepository;
  }

  @Override
  @Transactional
  public Transacao save(CreateTransacaoDto dto) {
    if (dto.latitude() == null ||
        dto.longitude() == null) {
      throw new RuntimeException("Latitude e longitude devem ser informadas");
    }

    Transacao transacao = new Transacao(dto.caixaId(),
        dto.contaId(),
        dto.tipoTransacao().charAt(0),
        dto.valor(),
        LocalDateTime.now(),
        dto.latitude(),
        dto.longitude());

    return transacaoRepository.save(transacao);
  }

  @Override
  public List<Transacao> findAll() {

    return transacaoRepository.findAll();
  }

  @Override
  public Transacao findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public void deleteById(Long id) {
    transacaoRepository.deleteById(id);
  }

  public void updateValor(Long id, UpdateValorDto dto) {
    Transacao transacao = transacaoRepository.findById(id).get();
    if (transacao == null) {
      throw new RuntimeException("Transacao não encontrada");
    }

    transacao.setValor(dto.valor());
    transacaoRepository.save(transacao);
  }

}