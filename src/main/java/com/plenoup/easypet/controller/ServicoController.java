package com.plenoup.easypet.controller;

import com.plenoup.easypet.core.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController()
@RequestMapping("/easypet/servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping("/{id_petshop}")
    public ResponseEntity<Object> buscarServicos(@PathVariable("id_petshop") final Integer idPetshop) {
        return ResponseEntity.ok().body(servicoService.buscaServicoPorIdPetshop(idPetshop));
    }

    @GetMapping("/{id_petshop}/")
    public ResponseEntity<Object> pesquisarServicos(@PathVariable("id_petshop") final Integer idPetshop,
                                                    @RequestParam(value = "nome") final String nome,
                                                    @RequestParam(value = "valor") final BigDecimal valor) {
        return ResponseEntity.ok().body(servicoService.buscaServicoPorIdPetshopNomeValor(idPetshop, nome, valor));
    }
}
