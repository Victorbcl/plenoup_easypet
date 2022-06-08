package com.plenoup.easypet.core.exception;

public class NoContentException extends RuntimeException {

    private static final String MESSAGE = "Recurso retornou resposta sem conteúdo";

    public NoContentException() {
        super(MESSAGE);
    }
}