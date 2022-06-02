package com.plenoup.easypet.service.adapter;

import com.plenoup.easypet.core.CepService;
import com.plenoup.easypet.service.adapter.response.CepResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.Map;

@Service
class CepServiceImpl implements CepService {

    @Value("${cep-service.url}")
    private String url;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public CepResponse buscaEndereco(final String cep) {
        final Map<String, String> params = Map.of("cep", cep);
        final URI finalUrl = new UriTemplate(url).expand(params);
        final CepResponse response = restTemplate.getForObject(finalUrl, CepResponse.class);
        return response;
    }
}