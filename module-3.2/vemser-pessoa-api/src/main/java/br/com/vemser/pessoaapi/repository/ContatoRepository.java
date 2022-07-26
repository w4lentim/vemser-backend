package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.enums.TipoDeContato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    @Query("SELECT c " +
            " FROM CONTATO c " +
            "WHERE c.tipo = :tipo")
    List<ContatoEntity> listContatoByTipo(@Param("tipo") TipoDeContato tipo);

    @Query("SELECT c " +
            " FROM CONTATO c")
    Page<ContatoEntity> listContatoByDescricao(Pageable pageable);
}
