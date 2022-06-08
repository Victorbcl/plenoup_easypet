package com.plenoup.easypet.service;

import com.plenoup.easypet.controller.dto.ServicoDTO;
import com.plenoup.easypet.core.ServicoService;
import com.plenoup.easypet.core.exception.NoContentException;
import com.plenoup.easypet.repository.ServicoRepository;
import com.plenoup.easypet.repository.entity.ServicoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public List<ServicoDTO> buscaServicoPorIdPetshop(final Integer idPetshop) {
        final List<ServicoEntity> servicoEntityList = servicoRepository.findByPetshop_Id(idPetshop);
        return servicoEntityList.stream().map(servicoEntity -> new ServicoDTO(servicoEntity)).collect(Collectors.toList());
    }

    @Override
    public List<ServicoDTO> buscaServicoPorIdPetshopNomeValor(final Integer idPetshop,
                                                              final String nome,
                                                              final BigDecimal valor) {
        final List<ServicoEntity> servicoEntityList = servicoRepository.findByPetshop_IdAndNomeContainingAndValor(idPetshop, nome, valor);
        servicoEntityList.stream().findAny().orElseThrow(NoContentException::new);
        return servicoEntityList.stream().map(servicoEntity -> new ServicoDTO(servicoEntity)).collect(Collectors.toList());
    }
}
