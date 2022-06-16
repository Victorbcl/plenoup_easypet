package com.plenoup.easypet.core.exception;

public class CepServiceException extends RuntimeException {

    private static final String MESSAGE = "Erro no serviço de consulta de cep";

    public CepServiceException() {
        super(MESSAGE);
    }
}