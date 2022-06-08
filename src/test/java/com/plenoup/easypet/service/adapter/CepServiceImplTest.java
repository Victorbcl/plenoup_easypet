package com.plenoup.easypet.service.adapter;

import com.plenoup.easypet.service.adapter.response.CepResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CepServiceImplTest {

    @InjectMocks
    private CepServiceImpl cepService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        MockitoAnnotations.openMocks(this);

        final Field url = CepServiceImpl.class.getDeclaredField("url");
        url.setAccessible(true);
        url.set(cepService, "/cep/{cep}");
    }

    @Test
    void Deve_Consultar_Api_Com_Suceso() {
        when(restTemplate.getForObject(any(URI.class), any())).thenReturn(new CepResponse());

        final CepResponse response = cepService.buscaEndereco("31000000");
        assertNotNull(response);
    }
}