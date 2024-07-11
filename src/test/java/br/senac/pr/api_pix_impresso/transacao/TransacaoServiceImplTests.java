package br.senac.pr.api_pix_impresso.transacao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import br.senac.pr.api_pix_impresso.shared.models.Transacao;
import br.senac.pr.api_pix_impresso.transacao.dtos.CreateTransacaoDto;
import br.senac.pr.api_pix_impresso.transacao.impl.TransacaoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TransacaoServiceImplTests {
  @Mock
  private TransacaoRepository transacaoRepository;

  @InjectMocks
  private TransacaoServiceImpl transacaoService;

  private CreateTransacaoDto createTransacaoDto;
  private Transacao transacao;

  @BeforeEach
  public void setup() {

    // Atualiza os objetos para os testes
    this.createTransacaoDto = new CreateTransacaoDto(Long.valueOf(1),
        Long.valueOf(1),
        "D",
        1000.00,
        -26.529,
        -56.2341);

    this.transacao = new Transacao(
        1L,
        1L,
        'D',
        1000.00,
        LocalDateTime.now(),
        -26.529,
        -56.2341);
  }

  @Test
  public void givenCreateTransacaoDto_whenSave_thenReturnTransacao() {
    // given
    // Atualiza o id da transação retornada pelo repository
    this.transacao.setId(1L);

    // Mock - simular o comportamento do repositório
    // Quando chamar a função de save do repositorio, retorne o objeto de transacao
    when(transacaoRepository.save(Mockito.any(Transacao.class)))
        .thenReturn(transacao);

    Transacao transacaoCreated = transacaoService.save(this.createTransacaoDto);

    Assertions.assertThat(transacaoCreated).isNotNull();
    Assertions.assertThat(transacaoCreated.getId())
        .isEqualTo(this.transacao.getId());
  }
}