package com.plenoup.easypet.controller.dto;

import com.plenoup.easypet.repository.entity.ServicoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ServicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public ServicoDTO(final ServicoEntity servicoEntity) {
        this.nome = servicoEntity.getNome();
        this.valor = servicoEntity.getValor();
    }

    private String nome;

    private BigDecimal valor;
}
