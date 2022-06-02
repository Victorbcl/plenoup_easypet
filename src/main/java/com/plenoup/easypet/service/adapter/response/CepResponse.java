package com.plenoup.easypet.service.adapter.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CepResponse {

    @JsonProperty("logradouro")
    private String logradouro;
}
