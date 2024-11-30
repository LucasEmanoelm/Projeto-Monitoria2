/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.Login;
import util.ConectaDB;
import java.sql.*;

/**
    Document   : Avaliação
    Created on : 27/11/2024
    Author     : Realizado por Grupo FFMIL
 */
public class LoginDAO {
    //Atrib.
    
    // Método responsável por consultar um usuário no banco de dados
    public Login consultar(Login p_usuario) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            // Estabelece a conexão com o banco de dados
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            
            // SQL para consultar se existe um usuário com o nome e senha informados
            String sql = "SELECT * FROM usuarios WHERE usuario = '" + p_usuario.getUsuario() + "' and senha = '" + p_usuario.getSenha() + "'";
            ResultSet rs = stmt.executeQuery(sql); // Executa a consulta SQL
            
            int n_reg = 0;
            // Itera sobre os resultados retornados pela consulta
            while (rs.next()) {                
                n_reg++; // Conta os registros encontrados
            }
            conexao.close();
            
            // Se nenhum registro for encontrado, retorna null (usuário não encontrado)
            if (n_reg == 0){
                return null;
            } else {
                return p_usuario; // Retorna o objeto p_usuario, caso o usuário seja encontrado
            }            
        }
        catch(SQLException ex){
            // Captura exceções SQL e imprime o erro
            System.out.println("Exception: " + ex);
            return null;
        }        
    }
}

