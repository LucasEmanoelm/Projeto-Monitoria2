<%-- 
    Document   : Avaliação
    Created on : 27/11/2024
    Author     : Realizado por Grupo FFMIL -
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Avaliacao"%>
<%@page import="model.dao.AvaliacaoDAO"%>

<%@page import="java.util.*"%>
<%@page import="java.text.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar</title>
    </head>
    <body>
        <h1>Alterar Avaliação</h1>
        <%
        
        // Entrada/Receber
        int id = Integer.parseInt(request.getParameter("id"));
        String matricula = request.getParameter("matricula");
        String nome = request.getParameter("nome");

        // Verificação para evitar erro de conversão
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        String dt_atual = request.getParameter("dt_atual");
        String dt_update = request.getParameter("dt_update");

        // Atribuindo os valores de forma segura
        try {
            r1 = Integer.parseInt(request.getParameter("r1"));
        } catch (NumberFormatException e) {
            // Caso o parâmetro não seja numérico ou esteja vazio, atribuímos 0
            r1 = 0;
        }

        try {
            r2 = Integer.parseInt(request.getParameter("r2"));
        } catch (NumberFormatException e) {
            r2 = 0;
        }

        try {
            r3 = Integer.parseInt(request.getParameter("r3"));
        } catch (NumberFormatException e) {
            r3 = 0;
        }

        try {
            r4 = Integer.parseInt(request.getParameter("r4"));
        } catch (NumberFormatException e) {
            r4 = 0;
        }

        try {
            r5 = Integer.parseInt(request.getParameter("r5"));
        } catch (NumberFormatException e) {
            r5 = 0;
        }

        // Instância e atribuição de valores
        Avaliacao aval = new Avaliacao();
        aval.setId(id);
        aval.setMatricula(matricula);
        aval.setNome(nome);
        aval.setApresentou(r1);
        aval.setIdentificou(r2);
        aval.setSondagem(r3);
        aval.setComunicacao(r4);
        aval.setResolveu(r5);
        aval.setDt_aval(dt_atual);
        aval.setDt_update(dt_update);

        // Insert
        AvaliacaoDAO avalDAO = new AvaliacaoDAO();
        if (avalDAO.altAval(aval)) {
            out.println("Registro Alterado com sucesso!");
        } else {
            out.println("Erro! Registro não Alterado!!!");
        }
        %>
    <body>
</head>
    