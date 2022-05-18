package com.plenoup.easypet.service;

import com.plenoup.easypet.entity.Petshop;
import com.plenoup.easypet.entity.Servico;
import com.plenoup.easypet.repository.PetshopRepository;
import com.plenoup.easypet.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private PetshopRepository petshopRepository;

    public List<Servico> buscaServicoPorIdPetshop(final Integer idPetshop) {
        final Optional<Petshop> optionalPetshop = petshopRepository.findById(idPetshop);
        return servicoRepository.findByPetshop(optionalPetshop.get());
    }
}
