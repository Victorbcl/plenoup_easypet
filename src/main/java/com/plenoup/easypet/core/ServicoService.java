package com.plenoup.easypet.core;

import com.plenoup.easypet.controller.dto.ServicoDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ServicoService {
    List<ServicoDTO> buscaServicoPorIdPetshop(final Integer idPetshop);

    List<ServicoDTO> buscaServicoPorIdPetshopNomeValor(final Integer idPetshop,
                                                       final String nome,
                                                       final BigDecimal valor);
}
