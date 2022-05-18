package com.plenoup.easypet.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "tb_servico")
@Getter
@Setter
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_petshop")
    private Petshop petshop;
}
