/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoservicecep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author aluno
 */
@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String nome;

    @Column(length = 20, nullable = false)
    private String login;

    @Column(length = 20, nullable = false)
    private String senha;

    @Override
    public String toString() {
        return "Usuario {"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", login='" + login + '\''
                + ", senha='" + senha + '\''
                + '}';
    }
}
