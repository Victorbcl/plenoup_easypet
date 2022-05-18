package com.plenoup.easypet.repository;

import com.plenoup.easypet.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
