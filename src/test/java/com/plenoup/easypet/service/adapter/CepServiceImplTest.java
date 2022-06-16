package com.plenoup.easypet.service.adapter;

import com.plenoup.easypet.core.exception.CepServiceException;
import com.plenoup.easypet.service.adapter.response.CepResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.net.URI;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowableOfType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        when(restTemplate.exchange(
                any(URI.class),
                any(HttpMethod.class),
                any(HttpEntity.class),
                any(ParameterizedTypeReference.class))
        ).thenReturn(ResponseEntity.ok(new CepResponse()));

        final CepResponse response = cepService.buscaEndereco("31000000");
        assertNotNull(response);

        final ArgumentCaptor<HttpMethod> methodArgumentCaptor = ArgumentCaptor.forClass(HttpMethod.class);
        final ArgumentCaptor<HttpEntity<Object>> httpEntityArgumentCaptor = ArgumentCaptor.forClass(HttpEntity.class);

        verify(restTemplate, times(1))
                .exchange(
                        any(URI.class),
                        methodArgumentCaptor.capture(),
                        httpEntityArgumentCaptor.capture(),
                        any(ParameterizedTypeReference.class)
                );

        final HttpMethod methodArgumentCaptorValue = methodArgumentCaptor.getValue();
        final HttpEntity<Object> httpEntityArgumentCaptorValue = httpEntityArgumentCaptor.getValue();

        assertNotNull(httpEntityArgumentCaptorValue);
        assertThat(httpEntityArgumentCaptorValue.getHeaders().size(), equalTo(1));
        assertThat(httpEntityArgumentCaptorValue.getHeaders().get("Content-Type").get(0), equalTo("application/json"));
        assertThat(methodArgumentCaptorValue, equalTo(HttpMethod.GET));
    }

    @Test
    void Deve_Consultar_Api_Com_Falha() {
        when(restTemplate.exchange(
                any(URI.class),
                any(HttpMethod.class),
                any(HttpEntity.class),
                any(ParameterizedTypeReference.class))
        ).thenReturn(ResponseEntity.ok(null));

        final Exception exception =
                catchThrowableOfType(
                        () -> cepService.buscaEndereco("31000000"),
                        Exception.class);

        assertTrue(exception instanceof CepServiceException);
        assertThat(exception.getMessage(), equalTo("Erro no serviço de consulta de cep"));
    }
}