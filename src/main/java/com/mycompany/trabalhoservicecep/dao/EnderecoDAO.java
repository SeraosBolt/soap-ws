/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoservicecep.dao;

import com.mycompany.trabalhoservicecep.model.Endereco;
import java.util.List;

/**
 *
 * @author aluno
 */
public class EnderecoDAO {

    void save(Endereco endereco);

    void update(Endereco endereco);

    void delete(Endereco endereco);

    Endereco findById(Long id);

    List<Endereco> findAll();

    Endereco findByCep(String cep);
}
