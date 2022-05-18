package com.plenoup.easypet.repository;

import com.plenoup.easypet.entity.PetshopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetshopRepository extends JpaRepository<PetshopEntity, Integer> {
}
