<%-- 
    Document   : Avaliação
    Created on : 27/11/2024
    Author     : Realizado por Grupo FFMIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="control.ControleLogin"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SportifyBet</title>
</head>
<body>
    <h1>Login</h1>
    <%
        String login = request.getParameter("login");
        String password = request.getParameter("pw");
        
        // Verifica se as credenciais foram recebidas
        if (login == null || password == null || login.trim().isEmpty() || password.trim().isEmpty()) {
            out.println("Por favor, preencha o login e a senha.");
        } else {
            ControleLogin ctrlLgn = new ControleLogin();
            // Tenta fazer o login
            if (ctrlLgn.logar(login, password)) {
                out.println("Acesso Permitido!!! <br>" + login);
                response.sendRedirect("menu/index.html");
            } else {
                out.println("Acesso <b>NEGADO</b>!!! ");
            }
        }
    %>
</body>
</html>


