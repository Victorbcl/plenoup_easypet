package com.plenoup.easypet.service;

import com.plenoup.easypet.controller.dto.ServicoDTO;
import com.plenoup.easypet.entity.PetshopEntity;
import com.plenoup.easypet.entity.ServicoEntity;
import com.plenoup.easypet.repository.PetshopRepository;
import com.plenoup.easypet.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private PetshopRepository petshopRepository;

    public List<ServicoDTO> buscaServicoPorIdPetshop(final Integer idPetshop) {
        final Optional<PetshopEntity> optionalPetshop = petshopRepository.findById(idPetshop);
        final List<ServicoEntity> servicoEntityList;
        try {
            servicoEntityList = servicoRepository.findByPetshop(optionalPetshop.get());
        } catch (NoSuchElementException e) {
            return List.of();
        }
        return servicoEntityList.stream().map(servicoEntity -> new ServicoDTO(servicoEntity)).collect(Collectors.toList());
    }

    public List<ServicoDTO> buscaServicoPorIdPetshopNomeValorServico(final Integer idPetshop,
                                                                     final String nome,
                                                                     final BigDecimal valor) {
        final Optional<PetshopEntity> optionalPetshop = petshopRepository.findById(idPetshop);
        final List<ServicoEntity> servicoEntityList;
        try {
            servicoEntityList = servicoRepository.findByNomeContainingAndValorAndPetshop(nome, valor, optionalPetshop.get());
        } catch (NoSuchElementException e) {
            return List.of();
        }
        return servicoEntityList.stream().map(servicoEntity -> new ServicoDTO(servicoEntity)).collect(Collectors.toList());
    }
}
