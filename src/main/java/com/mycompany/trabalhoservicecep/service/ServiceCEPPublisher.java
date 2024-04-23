/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoservicecep.service;

import jakarta.xml.ws.Endpoint;

/**
 *
 * @author aluno
 */
public class ServiceCEPPublisher {
        public static void main(String[] args) {

        Endpoint.publish("http://localhost:8080/usuario",
                new UsuarioSIB());

        Endpoint.publish("http://localhost:8080/endereco",
                new EnderecoSIB());

        System.out.println("Endpoints publicado com sucesso!");
    }
}
