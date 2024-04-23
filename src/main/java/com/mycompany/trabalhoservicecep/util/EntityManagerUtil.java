/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoservicecep.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class EntityManagerUtil {

    private static EntityManagerFactory emf; //uma vez só durante toda a aplicação
    private static EntityManager em; //cada requisição

    private EntityManagerUtil() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.
                    createEntityManagerFactory("HibernateMaven");
            System.out.println("conexão aberta");
        }
        return emf;
    }

    public static EntityManager getManager() {
        if (emf == null) {
            getEntityManagerFactory();
        }
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
            System.out.println("entity manager aberta");
        }
        return em;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            System.out.println("conexão fechada");
        }
    }
}
