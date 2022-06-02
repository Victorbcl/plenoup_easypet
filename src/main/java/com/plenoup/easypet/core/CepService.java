package com.plenoup.easypet.core;

import com.plenoup.easypet.service.adapter.response.CepResponse;

public interface CepService {

    CepResponse buscaEndereco(String cep);
}
