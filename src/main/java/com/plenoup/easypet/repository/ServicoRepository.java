package com.plenoup.easypet.repository;

import com.plenoup.easypet.entity.PetshopEntity;
import com.plenoup.easypet.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ServicoRepository extends JpaRepository<ServicoEntity, Integer> {

    List<ServicoEntity> findByPetshop(PetshopEntity petshopEntity);
}
