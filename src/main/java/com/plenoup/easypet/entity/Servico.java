package com.plenoup.easypet.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "tb_servico")
@Getter
@Setter
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;

    public Servico() {
    }

    public Servico(final Integer id, final String nome, final BigDecimal valor, final Petshop petshop) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.petshop = petshop;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_petshop")
    private Petshop petshop;
}
