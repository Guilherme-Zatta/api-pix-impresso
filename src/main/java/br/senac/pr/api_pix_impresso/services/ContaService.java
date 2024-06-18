package br.senac.pr.api_pix_impresso.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.pr.api_pix_impresso.models.Conta;
import br.senac.pr.api_pix_impresso.repositories.JdbcContaRepository;

// TODO - implementar um CRUD completo baseado nas chamadas do controller
@Service
public class ContaService implements BaseService<Conta, Long> {

  private JdbcContaRepository contaRepository;

  public ContaService(JdbcContaRepository contaRepository) {
    this.contaRepository = contaRepository;
  }

  @Override
  public int save(Conta object) {
    return contaRepository.save(object);
  }

  @Override
  public List<Conta> findAll() {
    return contaRepository.findAll();
  }

  @Override
  public Conta findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public int update(Conta object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void deleteById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }

}