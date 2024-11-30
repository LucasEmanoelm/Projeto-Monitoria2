/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.Avaliacao;
import java.sql.*;
import util.ConectaDB;
import java.util.List;
import java.util.ArrayList;

/**
    Document   : Avaliação
    Created on : 27/11/2024
    Author     : Realizado por Grupo FFMIL
 */
public class AvaliacaoDAO {
    
    // Método responsável por inserir uma nova avaliação no banco de dados
    public boolean insAval(Avaliacao p_aval) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            // Estabelece a conexão com o banco de dados
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            
            // SQL de inserção com os dados recebidos no objeto p_aval
            String sql = "INSERT INTO avaliacao(matricula, nome, apresentou, identificou, sondagem, comunicacao, resolveu, dt_aval) VALUES ('" + p_aval.getMatricula()+ "'," +
                                                                                                                                           "'" + p_aval.getNome()+ "'," +
                                                                                                                                               + p_aval.getApresentou()+ ", " +
                                                                                                                                               + p_aval.getIdentificou()+ ", " +
                                                                                                                                               + p_aval.getSondagem()+ ", "
                                                                                                                                               + p_aval.getComunicacao()+ ", "
                                                                                                                                               + p_aval.getResolveu()+ ", '"
                                                                                                                                               + p_aval.getDt_aval()+  "')";
            // Executa o comando SQL
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return false;
        }
    }   
    
    // Método responsável por consultar uma avaliação pelo seu ID
    public Avaliacao consAvalId(Avaliacao p_aval) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            // Estabelece a conexão com o banco de dados
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            
            // SQL para consultar a avaliação com o ID especificado
            String sql = "SELECT * FROM avaliacao where pkid = " + p_aval.getId();
            ResultSet rs = stmt.executeQuery(sql);
            
            int n_reg = 0;
            // Itera sobre os resultados retornados
            while (rs.next()) {                
                p_aval.setId(Integer.parseInt( rs.getString("pkid")));
                p_aval.setMatricula(rs.getString("matricula"));
                p_aval.setNome(rs.getString("nome"));
                p_aval.setApresentou(Integer.parseInt( rs.getString("apresentou") ));
                p_aval.setIdentificou(Integer.parseInt( rs.getString("identificou") ));
                p_aval.setSondagem(Integer.parseInt( rs.getString("sondagem") ));
                p_aval.setComunicacao(Integer.parseInt( rs.getString("comunicacao") ));
                p_aval.setResolveu(Integer.parseInt( rs.getString("resolveu") ));
                p_aval.setDt_aval( rs.getString("dt_aval"));
                p_aval.setDt_update(rs.getString("dt_update"));
                n_reg++;
            }
            conexao.close();
            
            // Retorna a avaliação se encontrada, ou null caso contrário
            if (n_reg == 0){
                return null;
            }else{
                return p_aval;               
            }
        }catch(SQLException ex){
            System.out.println("Exception: " + ex);
            return null;
        } 
    } 
    
    // Método responsável por consultar todas as avaliações
    public List consAvalLista() throws ClassNotFoundException{
        
        List lista = new ArrayList();
        
        Connection conexao = null;
        try{
            // Estabelece a conexão com o banco de dados
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            
            // SQL para consultar todas as avaliações
            String sql = "SELECT * FROM avaliacao";
            ResultSet rs = stmt.executeQuery(sql);
            
            int n_reg = 0;
            // Itera sobre os resultados e adiciona cada avaliação à lista
            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setId(Integer.parseInt( rs.getString("pkid")));
                avaliacao.setMatricula(rs.getString("matricula"));
                avaliacao.setNome(rs.getString("nome"));
                avaliacao.setApresentou(Integer.parseInt( rs.getString("apresentou") ));
                avaliacao.setIdentificou(Integer.parseInt( rs.getString("identificou") ));
                avaliacao.setSondagem(Integer.parseInt( rs.getString("sondagem") ));
                avaliacao.setComunicacao(Integer.parseInt( rs.getString("comunicacao") ));
                avaliacao.setResolveu(Integer.parseInt( rs.getString("resolveu") ));
                avaliacao.setDt_aval( rs.getString("dt_aval"));
                avaliacao.setDt_update(rs.getString("dt_update"));
                lista.add(avaliacao);
                n_reg++;
            }
            conexao.close();
            
            // Retorna a lista de avaliações, ou null caso não haja resultados
            if (n_reg == 0){
                return null;
            }else{
                return lista;               
            }
        }catch(SQLException ex){
            System.out.println("Exception: " + ex);
            return null;
        } 
    }  
    
    // Método responsável por excluir uma avaliação com base no seu ID
    public boolean exAvalId(Avaliacao p_aval) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            // Estabelece a conexão com o banco de dados
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            
            // SQL para excluir a avaliação com o ID especificado
            String sql = "DELETE FROM avaliacao WHERE pkid=" + p_aval.getId();
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return false;
        }
    }  
    
    // Método responsável por atualizar os dados de uma avaliação existente
    public boolean altAval(Avaliacao p_aval) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            // Estabelece a conexão com o banco de dados
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            
            // SQL para atualizar a avaliação com o ID especificado
            String sql = "UPDATE avaliacao SET matricula='" + p_aval.getMatricula()+ "'," + 
                                                    "nome='" + p_aval.getNome()+ "'," +
                                                    "apresentou=" + p_aval.getApresentou()+ ", " +
                                                    "identificou=" + p_aval.getIdentificou()+ ", " +
                                                    "sondagem=" + p_aval.getSondagem()+ ", " +
                                                    "comunicacao=" + p_aval.getComunicacao()+ ", " +
                                                    "resolveu=" + p_aval.getResolveu()+ ", " +
                                                    "dt_update='" + p_aval.getDt_update()+  
                                                    "' WHERE pkid=" + p_aval.getId();
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return false;
        }
    }   
}
