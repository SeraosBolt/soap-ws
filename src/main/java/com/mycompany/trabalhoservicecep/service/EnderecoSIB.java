/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoservicecep.service;

import jakarta.jws.WebService;
import java.util.List;

/**
 *
 * @author aluno
 */
@WebService(endpointInterface = "br.unipar.programacaointernet.servicecep.service.EnderecoSEI")
public class EnderecoSIB extends EnderecoSEI {
    public String boasVindas(String nome) {
        return "Bem Vindo(a) " + nome + "!";
    }

    @Override
    public String salvarEndereco(String cep, String logradouro, String complemento, String bairro, String localidade) {
        return null;
    }

    @Override
    public String editarEndereco(Long id, String cep, String logradouro, String complemento, String bairro, String localidade) {
        return null;
    }

    @Override
    public String deletarEndereco(Long id) {
        return null;
    }

    @Override
    public Endereco consultaEnderecoPorID(Long id) {
        return null;
    }

    @Override
    public List<Endereco> consultaEnderecos() {
        EnderecoDAO enderecoDAO = new EnderecoDAOImpl(EntityManagerUtil.getManager());

        return enderecoDAO.findAll();
    }

    @Override
    public Endereco consultaPorCep(String cep) {
        EnderecoDAO enderecoDAO = new EnderecoDAOImpl(EntityManagerUtil.getManager());

        Endereco endereco = enderecoDAO.findByCep(cep);

        if(endereco == null) {
            try {
                endereco = Main.getViaCep(cep);

                if(endereco.getCep() == null) {
                    //validação - retorna pro usuario algo avisando
                } else {
                    enderecoDAO.save(endereco);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return endereco;
    }


}