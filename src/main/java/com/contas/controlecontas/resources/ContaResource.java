package com.contas.controlecontas.resources;

import java.util.List;

import com.contas.controlecontas.models.Conta;
import com.contas.controlecontas.repository.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value="/api")
public class ContaResource {

  @Autowired
  ContaRepository contaRepository;

  @GetMapping("/conta")
  public List<Conta> listConta () {
    return contaRepository.findAll();
  }
  
  @GetMapping("/conta/{id}")
  public Conta listContaId (@PathVariable(value="id") long id) {
    return contaRepository.findById(id);
  }

  @PostMapping("/conta")
  public Conta createConta (@RequestBody Conta conta) {
    return contaRepository.save(conta);
  }

  @DeleteMapping("/conta")
  public void deleteConta (@RequestBody Conta conta) {
    try {
      contaRepository.delete(conta);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @PutMapping(value="conta")
  public Conta updateConta(@RequestBody Conta conta) {
      
    return contaRepository.save(conta);
  }
}