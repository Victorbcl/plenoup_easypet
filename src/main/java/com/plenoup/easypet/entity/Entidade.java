package com.plenoup.easypet.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_usuarios")
public class Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true, name = "email")
    private String email;
}
