package com.plenoup.easypet.controller;

import com.plenoup.easypet.controller.dto.ServicoDTO;
import com.plenoup.easypet.core.ServicoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
        final Integer idPetshop = 1;

        when(servicoService.buscaServicoPorIdPetshop(idPetshop)).thenReturn(List.of(new ServicoDTO()));

        final ResponseEntity<Object> responseEntity = servicoController.buscarServicos(idPetshop);

        assertThat(responseEntity, notNullValue());
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(responseEntity.getBody(), notNullValue());

        assertThat(responseEntity.getBody(), instanceOf(List.class));
        final List<Object> responseList = (List<Object>) responseEntity.getBody();

        assertThat(responseList.get(0), instanceOf(ServicoDTO.class));
    }
}