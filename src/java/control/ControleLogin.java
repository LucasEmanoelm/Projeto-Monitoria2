/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Login;
import model.dao.LoginDAO;

/**
    Document   : Avaliação
    Created on : 27/11/2024
    Author     : Realizado por Grupo FFMIL
 */
public class ControleLogin {
    // Métodos

    // Método responsável por realizar a autenticação do usuário
    public boolean logar(String p_usuario, String p_senha) {
        // Cria um objeto Login e seta os valores de usuário e senha
        Login lgn = new Login();
        lgn.setUsuario(p_usuario);
        lgn.setSenha(p_senha);
        
        // Cria uma instância do LoginDAO para realizar a consulta no banco de dados
        LoginDAO lgnDAO = new LoginDAO();
        try {
            // Verifica se o usuário existe no banco de dados
            // Se o método consultar() retornar um objeto (ou seja, o usuário foi encontrado), retorna true
            return lgnDAO.consultar(lgn) != null; 
        } catch (ClassNotFoundException e) {
            // Caso ocorra uma exceção, imprime o erro no console
            e.printStackTrace();
            return false; // Retorna false em caso de erro, indicando falha na autenticação
        }
    }
}

