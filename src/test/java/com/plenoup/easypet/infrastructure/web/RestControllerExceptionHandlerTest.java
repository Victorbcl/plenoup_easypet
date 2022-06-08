package com.plenoup.easypet.infrastructure.web;

import com.plenoup.easypet.commons.WebRequestTest;
import com.plenoup.easypet.core.exception.NoContentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RestControllerExceptionHandlerTest {

    private RestControllerExceptionHandler restControllerExceptionHandler;

    private WebRequest webRequest;

    @BeforeEach
    void setUp() {
        restControllerExceptionHandler = new RestControllerExceptionHandler();
        webRequest = WebRequestTest.getWebRequest();
    }

    @Test
    void testNoContentException() {
        final ResponseEntity<Object> response =
                restControllerExceptionHandler.handleException(new NoContentException(), webRequest);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}