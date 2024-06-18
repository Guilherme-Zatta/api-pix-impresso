package br.senac.pr.api_pix_impresso.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.api_pix_impresso.dtos.CreateContaDto;
import br.senac.pr.api_pix_impresso.models.Conta;
import br.senac.pr.api_pix_impresso.services.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

  private ContaService contaService;

  public ContaController(ContaService contaService) {
    this.contaService = contaService;
  }

  // POST - Cria uma nova conta
  @PostMapping("")
  public ResponseEntity<Conta> createConta(@RequestBody CreateContaDto dto) {
    // Criar um objeto da classe Conta
    Conta conta = new Conta(null,
        dto.getAgencia(), dto.getNumeroConta(),
        dto.getDigitoVerificador(), dto.getNome(),
        dto.getCpf(), dto.getTipoConta(),
        dto.getNumeroCartao(), dto.getSenha(),
        dto.getSaldo());
    // Salvar no banco
    int id = contaService.save(conta);
    conta.setId(Long.valueOf(id));
    // retornar o objeto conta o id
    return ResponseEntity.ok().body(conta);
  }

  // GET - Lista todas as contas
  @GetMapping("")
  public List<Conta> getContas() {
    return contaService.findAll();
  }
  // GET - Lista uma conta por ID
  // PUT - Atualiza uma conta
  // PATCH - Atualiza parcialmente uma conta
  // DELETE - Deleta uma conta
}