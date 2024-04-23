/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoservicecep.dao;

import com.mycompany.trabalhoservicecep.model.Usuario;
import com.mycompany.trabalhoservicecep.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author aluno
 */
public class UsuarioDAOImpl {
     private EntityManager em = EntityManagerUtil.getManager();

    public UsuarioDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Usuario usuario) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(usuario);
        transaction.commit();
        System.out.println("Usuário " + usuario.getNome() +
                " salvo com sucesso!");
    }

    @Override
    public void update(Usuario usuario) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(usuario);
        transaction.commit();
        System.out.println("Usuário " + usuario.getNome() +
                " atualizado com sucesso!");
    }

    @Override
    public void delete(Usuario usuario) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(usuario);
        transaction.commit();
        System.out.println("Usuário " + usuario.getNome() +
                " removido com sucesso!");
    }

    @Override
    public Usuario findById(Long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> findAll() {
        return em.createQuery("SELECT u FROM Usuario u",
                Usuario.class).getResultList();
    }
}
