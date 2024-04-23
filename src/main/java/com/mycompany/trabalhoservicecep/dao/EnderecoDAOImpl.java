/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoservicecep.dao;

import java.util.List;
import javax.persistence.EntityTransaction;

/**
 *
 * @author aluno
 */
public class EnderecoDAOImpl {
        private EntityManager em = EntityManagerUtil.getManager();

    public EnderecoDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Endereco endereco) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(endereco);
        transaction.commit();
        System.out.println("Endereço " + endereco.toString() +
                " salvo com sucesso!");
    }

    @Override
    public void update(Endereco endereco) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(endereco);
        transaction.commit();
        System.out.println("Endereço " + endereco.toString() +
                " atualizado com sucesso!");
    }

    @Override
    public void delete(Endereco endereco) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(endereco);
        transaction.commit();
        System.out.println("Endereço " + endereco.toString() +
                " removido com sucesso!");
    }

    @Override
    public Endereco findById(Long id) {
        return em.find(Endereco.class, id);
    }

    @Override
    public List<Endereco> findAll() {
        return em.createQuery("SELECT e FROM Endereco e",
                Endereco.class).getResultList();
    }

    @Override
    public Endereco findByCep(String cep) {
        try {
            return em.createQuery("SELECT e FROM Endereco e WHERE cep = :c",
                            Endereco.class)
                    .setParameter("c", cep)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
