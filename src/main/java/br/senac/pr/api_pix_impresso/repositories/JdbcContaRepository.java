package br.senac.pr.api_pix_impresso.repositories;
// TODO - Implementar a interface BaseJdbcRepository

// Implementar todos os métodos para serem usados pelo service

import java.util.List;
import java.util.Optional;

import br.senac.pr.api_pix_impresso.models.Conta;

public class JdbcContaRepository implements BaseJdbcRepository<Conta, Long> {

  @Override
  public int save(Conta object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public int deleteAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
  }

}