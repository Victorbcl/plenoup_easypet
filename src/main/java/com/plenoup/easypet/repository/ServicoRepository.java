package com.plenoup.easypet.repository;

import com.plenoup.easypet.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository

public interface ServicoRepository extends JpaRepository<ServicoEntity, Integer> {

    List<ServicoEntity> findByPetshop_Id(Integer petshopId);

    List<ServicoEntity> findByPetshop_IdAndNomeContainingAndValor(@Param("petshopId") Integer petshopId,
                                                                  @Param("nome") String nome,
                                                                  @Param("valor") BigDecimal valor);
}
