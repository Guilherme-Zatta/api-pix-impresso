package br.senac.pr.api_pix_impresso.transacao;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import br.senac.pr.api_pix_impresso.shared.models.Transacao;

@DataJdbcTest()
@TestPropertySource(locations = "classpath:/test/application-test.properties")
@Sql(scripts = { "classpath:/test/db/schema.sql",
    "classpath:/test/db/data.sql" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class TransacaoRepositoryTests {

  @Autowired
  private TransacaoRepository transacaoRepository;

  @Test
  public void createTransacao() {

    // given
    // dado uma nova transacao
    Transacao transacao = new Transacao(1L, 1L, 'D', 1000.00, LocalDateTime.now(), -26.529, -56.2341);

    // when
    // quando essa transacao for inserida ou salva no banco
    var transacaoCreated = transacaoRepository.save(transacao);

    // then
    // então deve validar se a transacao foi inserida no banco
    Assertions.assertThat(transacaoCreated.getId()).isNotNull();
  }

}