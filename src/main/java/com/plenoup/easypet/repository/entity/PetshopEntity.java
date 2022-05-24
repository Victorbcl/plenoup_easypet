package com.plenoup.easypet.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "tb_petshop")
@Getter
@Setter
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class PetshopEntity {
    private static final long serialVersionUID = 1L;

    public PetshopEntity() {
    }

    public PetshopEntity(final Integer id, final String nome, final List<ServicoEntity> servicos) {
        this.id = id;
        this.nome = nome;
        this.servicos = servicos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "petshop")
    private List<ServicoEntity> servicos;
}
