<%-- 
    Document   : Avaliação
    Created on : 27/11/2024
    Author     : Realizado por Grupo FFMIL -
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>  <!-- Define o tipo de conteúdo e a codificação da página JSP -->
<%@page import="model.Avaliacao"%> <!-- Importa a classe Avaliacao -->
<%@page import="model.dao.AvaliacaoDAO"%> <!-- Importa a classe AvaliacaoDAO -->
<%@page import="java.util.*"%> <!-- Importa utilitários Java -->
<%@page import="java.text.*"%> <!-- Importa pacotes para formatação de data -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  <!-- Define o tipo de conteúdo da página -->
        <title>JSP Page</title>  <!-- Define o título da página -->
    </head>
    <body>
        <h1>Avaliação - Monitoring Solutions</h1>
        <%
        // Entrada: Recebe os parâmetros enviados pelo formulário
        String matricula = request.getParameter("matricula"); // Matrícula
        String nome = request.getParameter("nome"); // Nome do usuário
        int r1 = Integer.parseInt(request.getParameter("r1")); // Nota 1
        int r2 = Integer.parseInt(request.getParameter("r2")); // Nota 2
        int r3 = Integer.parseInt(request.getParameter("r3")); // Nota 3
        int r4 = Integer.parseInt(request.getParameter("r4")); // Nota 4
        int r5 = Integer.parseInt(request.getParameter("r5")); // Nota 5

        // Instância da classe Avaliacao e atribuição de valores recebidos
        Avaliacao aval = new Avaliacao();
        aval.setMatricula(matricula); // Atribui a matrícula
        aval.setNome(nome); // Atribui o nome
        aval.setApresentou(r1); // Atribui a nota 1
        aval.setIdentificou(r2); // Atribui a nota 2
        aval.setSondagem(r3); // Atribui a nota 3
        aval.setComunicacao(r4); // Atribui a nota 4
        aval.setResolveu(r5); // Atribui a nota 5
        aval.setDt_aval(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())); // Atribui a data e hora atual

        // Instância da classe AvaliacaoDAO para inserir os dados no banco
        AvaliacaoDAO avalDAO = new AvaliacaoDAO();
        if(avalDAO.insAval(aval)){  // Tenta inserir a avaliação
            out.println("Avaliação inserida com sucesso!"); // Se a inserção for bem-sucedida
        }else{
           out.println("Avaliação não inserida, Erro!!!"); // Se ocorrer algum erro durante a inserção
        }
        %>
    </body>
</html>


