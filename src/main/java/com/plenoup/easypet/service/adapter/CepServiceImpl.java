package com.plenoup.easypet.service.adapter;

import com.plenoup.easypet.core.CepService;
import com.plenoup.easypet.service.adapter.response.CepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.Map;

@Service
class CepServiceImpl implements CepService {

    @Value("${cep-service.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CepResponse buscaEndereco(final String cep) {
        final Map<String, String> params = Map.of("cep", cep);
        final URI finalUrl = new UriTemplate(url).expand(params);
        final ResponseEntity<CepResponse> response = restTemplate.exchange(
                finalUrl,
                HttpMethod.GET,
                new HttpEntity<>(getHttpHeaders()),
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    private HttpHeaders getHttpHeaders() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return httpHeaders;
    }
}