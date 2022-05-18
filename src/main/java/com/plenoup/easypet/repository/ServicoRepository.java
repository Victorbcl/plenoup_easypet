package com.plenoup.easypet.repository;

import com.plenoup.easypet.entity.Petshop;
import com.plenoup.easypet.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    List<Servico> findByPetshop(Petshop petshop);
}
