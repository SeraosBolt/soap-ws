/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoservicecep.dao;

import com.mycompany.trabalhoservicecep.model.Usuario;
import java.util.List;

/**
 *
 * @author aluno
 */
public class UsuarioDAO {

    void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(Usuario usuario);

    Usuario findById(Long id);

    List<Usuario> findAll();
}
