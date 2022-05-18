package com.plenoup.easypet.controller;

import com.plenoup.easypet.controller.dto.ServicoDTO;
import com.plenoup.easypet.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/{id_petshop}")
    public ResponseEntity<Object> findByPetshop(@PathVariable("id_petshop") final Integer idPetshop) {
        return ResponseEntity.ok().body(servicoService.buscaServicoPorIdPetshop(idPetshop));
    }

    @GetMapping("/{id_petshop}/")
    public ResponseEntity<Object> findByPetshop(@PathVariable("id_petshop") final Integer idPetshop,
                                                @RequestParam(value = "nome") String nome,
                                                @RequestParam(value = "valor") BigDecimal valor) {
        List<ServicoDTO> servicoDTOList = servicoService.buscaServicoPorIdPetshopNomeValorServico(idPetshop, nome, valor);
        return ResponseEntity.ok().body(servicoDTOList);
    }
}
