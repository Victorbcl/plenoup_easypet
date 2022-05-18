package com.plenoup.easypet.controller;

import com.plenoup.easypet.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/{id_petshop}")
    public ResponseEntity<Object> findByPetshop(@PathVariable("id_petshop") final Integer idPetshop) {
        return ResponseEntity.ok().body(servicoService.buscaServicoPorIdPetshop(idPetshop));
    }
}
