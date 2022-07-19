package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findAllByNomeIgnoreCase(String nome);

    PessoaEntity findAllByCpf(String cpf);

    List<PessoaEntity> findAllByDataNascimentoStartDateBetween(LocalDate dataNascimento, LocalDate dataFinal);
}