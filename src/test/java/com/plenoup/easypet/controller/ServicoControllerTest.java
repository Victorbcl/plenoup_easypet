package com.plenoup.easypet.controller;

import com.plenoup.easypet.controller.dto.ServicoDTO;
import com.plenoup.easypet.core.ServicoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ServicoControllerTest {

    @Mock
    private ServicoService servicoService;

    @InjectMocks
    private ServicoController servicoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void Deve_RetornarSucesso_Quando_Executar_BuscarServicos_IdPetshop_Valido() {
        when(servicoService.buscaServicoPorIdPetshop(anyInt())).thenReturn(List.of(new ServicoDTO()));

        final ResponseEntity<Object> responseEntity = servicoController.buscarServicos(1);

        assertThat(responseEntity, notNullValue());
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(responseEntity.getBody(), notNullValue());

        assertThat(responseEntity.getBody(), instanceOf(List.class));
        final List<Object> responseList = (List<Object>) responseEntity.getBody();

        assertThat(responseList.get(0), instanceOf(ServicoDTO.class));
    }

    @Test
    void Deve_RetornarSucesso_Quando_Executar_PesquisarServicos_IdPetshop_Nome_Valor_Validos() {
        when(servicoService.buscaServicoPorIdPetshopNomeValor(anyInt(), anyString(), ArgumentMatchers.any(BigDecimal.class)))
                .thenReturn(List.of(new ServicoDTO()));

        final ResponseEntity<Object> responseEntity =
                servicoController.pesquisarServicos(1, "nome", BigDecimal.ONE);

        assertThat(responseEntity, notNullValue());
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(responseEntity.getBody(), notNullValue());

        assertThat(responseEntity.getBody(), instanceOf(List.class));
        final List<Object> responseList = (List<Object>) responseEntity.getBody();

        assertThat(responseList.get(0), instanceOf(ServicoDTO.class));
    }
}