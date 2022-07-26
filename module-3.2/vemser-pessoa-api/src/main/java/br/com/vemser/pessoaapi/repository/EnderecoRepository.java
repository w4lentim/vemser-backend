package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query("SELECT ep " +
            " FROM ENDERECO_PESSOA ep " +
            "WHERE ep.pais = :pais")
    List<EnderecoEntity> listEnderecoByPais(@Param("pais") String pais);

    @Query("SELECT ep " +
            "FROM ENDERECO_PESSOA ep")
    Page<EnderecoEntity> listEnderecoOrderedByCep(Pageable pageable);

    @Query("SELECT ep " +
            " FROM ENDERECO_PESSOA ep " +
            "WHERE (:pais is null or ep.pais = :pais)")
    Page<EnderecoEntity> listEnderecoOrderedByPais(@Param("pais") String pais, Pageable pageable);
}