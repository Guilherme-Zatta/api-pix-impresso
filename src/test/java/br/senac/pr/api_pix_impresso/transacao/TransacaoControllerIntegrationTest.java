package br.senac.pr.api_pix_impresso.transacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import br.senac.pr.api_pix_impresso.ApiPixImpressoApplication;
import br.senac.pr.api_pix_impresso.shared.models.Transacao;
import br.senac.pr.api_pix_impresso.transacao.dtos.CreateTransacaoDto;

@SpringBootTest(classes = ApiPixImpressoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class TransacaoControllerIntegrationTest {
  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate testRestTemplate;

  // deve criar uma transação com latitude e longitude
  @Test
  @Order(1)
  public void shouldCreateTransacaoWithLatitudeAndLogitude() {
    // given - dado o objeto de criação da transação
    CreateTransacaoDto transacao = new CreateTransacaoDto(
        Long.valueOf(1),
        Long.valueOf(1),
        "D",
        1000.00,
        -26.529,
        -56.2341);

    // when - quando for chamada a rota de criação da transação
    ResponseEntity<Transacao> response = this.testRestTemplate
        .postForEntity("http://localhost:" + port + "/transacoes",
            transacao,
            Transacao.class);
    var transacaoCreated = response.getBody();

    // then - então deve validar os resultados
    // EXPECTATIVAS (EXPECTATIONS)
    // afirmo que o objeto de transação não é nulo
    assertTrue(transacaoCreated != null);
    // afirmo (assert) que o objeto de transação criado
    // tem o mesmo valor que o objeto de transação passado (given)
    assertTrue(transacaoCreated.getValor().equals(transacao.valor()));
    assertTrue(transacaoCreated.getLatitude().equals(transacao.latitude()));
    assertTrue(transacaoCreated.getLongitude().equals(transacao.longitude()));
  }

  // não deve criar uma transação sem latitude e longitude
  @Test
  @Order(2)
  public void shouldNotCreateTransacaoWithoutLatitudeAndLogitude() {
    var transacao = new CreateTransacaoDto(Long.valueOf(1),
        Long.valueOf(1),
        "D",
        1000.00,
        null,
        null);

    ResponseEntity<String> response = this.testRestTemplate
        .postForEntity("http://localhost:" + port + "/transacoes",
            transacao,
            String.class);
    var transacaoCreated = response.getBody();
    // expectativas (expectations)
    assertEquals(transacaoCreated, "Latitude e longitude devem ser informadas");
    assertEquals(500, response.getStatusCode().value());
  }

}