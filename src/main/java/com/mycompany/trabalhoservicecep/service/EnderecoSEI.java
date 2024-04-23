/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoservicecep.service;

import com.mycompany.trabalhoservicecep.model.Endereco;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

/**
 *
 * @author aluno
 */
@WebService
public interface EnderecoSEI {

    @WebMethod
    String boasVindas(@WebParam(name = "nome") String nome);

    @WebMethod
    String salvarEndereco(@WebParam(name = "cep") String cep,
                          @WebParam(name = "logradouro") String logradouro,
                          @WebParam(name = "complemento") String complemento,
                          @WebParam(name = "bairro") String bairro,
                          @WebParam(name = "localidade") String localidade);

    @WebMethod
    String editarEndereco(@WebParam(name = "id") Long id,
                          @WebParam(name = "cep") String cep,
                          @WebParam(name = "logradouro") String logradouro,
                          @WebParam(name = "complemento") String complemento,
                          @WebParam(name = "bairro") String bairro,
                          @WebParam(name = "localidade") String localidade);

    @WebMethod
    String deletarEndereco(@WebParam(name = "id") Long id);

    @WebMethod
    Endereco consultaEnderecoPorID(@WebParam(name = "idEndereco") Long id);
    @WebMethod
    List<Endereco> consultaEnderecos();

    @WebMethod
    Endereco consultaPorCep(@WebParam(name = "cep") String cep);
}
