package com.plenoup.easypet.service;

import com.plenoup.easypet.controller.dto.ServicoDTO;
import com.plenoup.easypet.core.exception.NoContentException;
import com.plenoup.easypet.repository.ServicoRepository;
import com.plenoup.easypet.repository.entity.ServicoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowableOfType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ServicoServiceImplTest {

    @InjectMocks
    private ServicoServiceImpl servicoServiceImpl;

    @Mock
    private ServicoRepository servicoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void Deve_RetornarSucesso_Quando_Executar_BuscaServico_IdPetshop() {
        when(servicoRepository.findByPetshop_Id(anyInt())).thenReturn(List.of(new ServicoEntity()));

        final List<ServicoDTO> servicoDTOList = servicoServiceImpl.buscaServicoPorIdPetshop(1);
        assertThat(servicoDTOList, notNullValue());
    }

    @Test
    void Deve_RetornarSucesso_Quando_Executar_PesquisarServicos_IdPetshop_Nome_Valor_Validos() {
        when(servicoRepository.findByPetshop_IdAndNomeContainingAndValor(anyInt(), anyString(), ArgumentMatchers.any()))
                .thenReturn(List.of(new ServicoEntity()));

        final List<ServicoDTO> servicoDTOList =
                servicoServiceImpl.buscaServicoPorIdPetshopNomeValor(1, "nome", BigDecimal.ONE);
        assertThat(servicoDTOList, notNullValue());
    }

    @Test
    void Deve_Lancar_NoContentException_Quando_Executar_PesquisarServicos_IdPetshop_Nome_Valor_Invalidos() {
        when(servicoRepository.findByPetshop_IdAndNomeContainingAndValor(anyInt(), anyString(), ArgumentMatchers.any()))
                .thenReturn(List.of());

        final Exception exception =
                catchThrowableOfType(
                        () -> servicoServiceImpl.buscaServicoPorIdPetshopNomeValor(1, "nome", BigDecimal.ONE),
                        Exception.class);

        assertTrue(exception instanceof NoContentException);
    }
}