package br.senac.pr.api_pix_impresso.repositories;
// TODO - Implementar a interface BaseJdbcRepository

import java.util.HashMap;

// Implementar todos os métodos para serem usados pelo service

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import br.senac.pr.api_pix_impresso.models.Caixa;
import br.senac.pr.api_pix_impresso.models.Conta;

@Repository
public class JdbcContaRepository implements BaseJdbcRepository<Conta, Long> {

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  private JdbcTemplate jdbcTemplate;

  public JdbcContaRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
      JdbcTemplate jdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int save(Conta object) {
    GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

    // SQL placeholders can use named parameters instead of "?".
    String sql = """
        INSERT INTO public.contas
            (agencia, numero_conta, digito_verificador,
            nome, cpf, tipo_conta,
            numero_cartao, senha, saldo)
        VALUES (:agencia, :numero_conta, :digito_verificador,
            :nome, :cpf, :tipo_conta,
            :numero_cartao, :senha, :saldo)
        """;

    Map<String, Object> params = new HashMap<>();
    params.put("agencia", object.getAgencia());
    params.put("numero_conta", object.getNumeroConta());
    params.put("digito_verificador", object.getDigitoVerificador());
    params.put("nome", object.getNome());
    params.put("cpf", object.getCpf());
    params.put("tipo_conta", object.getTipoConta());
    params.put("numero_cartao", object.getNumeroCartao());
    params.put("senha", object.getSenha());
    params.put("saldo", object.getSaldo());

    // Executar a instrução SQL para criar um novo registro
    namedParameterJdbcTemplate.update(sql,
        new MapSqlParameterSource(params),
        generatedKeyHolder);

    var returnedKeys = generatedKeyHolder.getKeys();
    if (returnedKeys == null) {
      throw new Error("Erro ao salvar a conta");
    }
    // Obtem do registro inserido, o ID gerado pelo banco
    Integer id = (Integer) returnedKeys.get("ID");

    return id;
  }

  @Override
  public int update(Conta object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public Optional<Conta> findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public int deleteById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }

  @Override
  public List<Conta> findAll() {
    String selectQuery = """
          SELECT
            id, agencia, numero_conta,
            digito_verificador, nome, cpf, tipo_conta,
            numero_cartao, senha, saldo
          FROM contas
        """;
    return jdbcTemplate
        .query(selectQuery,
            (rs, rowNum) -> {
              return new Conta(rs.getLong("ID"),
                  rs.getLong("AGENCIA"),
                  rs.getLong("NUMERO_CONTA"),
                  rs.getLong("DIGITO_VERIFICADOR"),
                  rs.getString("NOME"),
                  rs.getString("CPF"),
                  rs.getLong("TIPO_CONTA"),
                  rs.getString("NUMERO_CARTAO"),
                  rs.getString("SENHA"),
                  rs.getDouble("SALDO"));
            });
  }

  @Override
  public int deleteAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
  }

}