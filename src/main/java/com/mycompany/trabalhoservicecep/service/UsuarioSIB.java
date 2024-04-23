/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoservicecep.service;

import com.mycompany.trabalhoservicecep.dao.UsuarioDAO;
import com.mycompany.trabalhoservicecep.dao.UsuarioDAOImpl;
import com.mycompany.trabalhoservicecep.model.Usuario;
import com.mycompany.trabalhoservicecep.util.EntityManagerUtil;
import jakarta.jws.WebService;
import java.util.List;

/**
 *
 * @author aluno
 */
@WebService(endpointInterface = "br.unipar.programacaointernet.servicecep.service.UsuarioSEI")
public class UsuarioSIB implements UsuarioSEI {
    @Override
    public String boasVindas(String nome) {
        return "Bem Vindo(a) " + nome + "!";
    }

    @Override
    public String salvarUsuario(String nome, String login, String senha) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil
                .getManager());

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);

        usuarioDAO.save(usuario);

        return "Usuário " + usuario.getNome() + " salvo com sucesso!";
    }

    @Override
    public String editarUsuario(Long id,
                              String nome,
                              String login,
                              String senha) {

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil
                .getManager());

        Usuario usuario = usuarioDAO.findById(id);

        if (nome != null)
            usuario.setNome(nome);

        if (login != null)
            usuario.setLogin(login);

        if (senha != null)
            usuario.setSenha(senha);

        usuarioDAO.update(usuario);

        return "Usuário " + usuario.getNome() + " alterado com sucesso!";
    }

    @Override
    public String deletarUsuario(Long id) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil
                .getManager());

        Usuario usuario = usuarioDAO.findById(id);
        usuarioDAO.delete(usuario);

        return "Usuário " + usuario.getNome() +
                " removido com sucesso!";
    }

    @Override
    public Usuario consultaUsuarioPorID(Long id) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil
                .getManager());

        return usuarioDAO.findById(id);
    }

    @Override
    public List<Usuario> consultaUsuarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil
                .getManager());

        return usuarioDAO.findAll();
    }
}
