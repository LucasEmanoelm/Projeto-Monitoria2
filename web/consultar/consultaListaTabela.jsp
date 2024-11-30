<%-- 
    Document   : Avaliação
    Created on : 28/11/2024
    Author     : Realizado por Grupo FFMIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Avaliacao"%>
<%@page import="model.dao.AvaliacaoDAO"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>

<!DOCTYPE html>
<html>
    <head>
        <!-- Meta tag para definir o tipo de conteúdo da página e a codificação de caracteres -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Inclusão do arquivo CSS para estilizar a tabela -->
        <link href="tabela.css" rel="stylesheet" type="text/css"/>
        
        <!-- Título da página, exibido na aba do navegador -->
        <title>Consulta</title>
    </head>
    <body>
        <!-- Cabeçalho da página -->
        <h3>Tabela de Avaliações</h3>
        
        <%              
        // Criação de um objeto AvaliacaoDAO para acessar os dados de avaliação
        AvaliacaoDAO avalDAO = new AvaliacaoDAO();
         
        // Criação de uma lista de avaliações
        List<Avaliacao> lista = new ArrayList<>();
        
        // Chamando o método que retorna a lista de avaliações do banco de dados
        lista = avalDAO.consAvalLista();

        // Variável para contar o número de registros
        int n_reg = 0 ;
        
        // Imprime um título na página com o número de registros
        out.println("<br> <b>Avaliação de Monitoria - Registros</b>");
            
        %>      
        
        <!-- Cabeçalho da tabela, definindo os títulos das colunas -->
        <table border="1">
                <tr>
                    <th>#</th>
                    <th>Id.</th>
                    <th>Matricula</th>
                    <th>Nome</th>
                    <th>Nota1</th>
                    <th>Nota2</th>
                    <th>Nota3</th>
                    <th>Nota4</th>
                    <th>Nota5</th>
                    <th>Data</th>
                    <th>Data Atualização</th>
                </tr>                     

        <%
        // Laço para percorrer a lista de avaliações e exibir os dados em cada linha da tabela
        for( int i = 0; i <= lista.size()-1; i++){            
        %>            
            <!-- Cada linha da tabela é preenchida com os dados da avaliação -->
            <tr>
                    <td><%=i+1%></td> <!-- Exibe o número de sequência -->
                    <td><%=lista.get(i).getId()%></td> <!-- Exibe o ID da avaliação -->
                    <td><%=lista.get(i).getMatricula()%></td> <!-- Exibe a matrícula -->
                    <td><%=lista.get(i).getNome()%></td> <!-- Exibe o nome -->
                    <td><%=lista.get(i).getApresentou()%></td> <!-- Exibe a nota 1 -->
                    <td><%=lista.get(i).getIdentificou()%></td> <!-- Exibe a nota 2 -->
                    <td><%=lista.get(i).getSondagem()%></td> <!-- Exibe a nota 3 -->
                    <td><%=lista.get(i).getComunicacao()%></td> <!-- Exibe a nota 4 -->
                    <td><%=lista.get(i).getResolveu()%></td> <!-- Exibe a nota 5 -->
                    <td><%=lista.get(i).getDt_aval()%></td> <!-- Exibe a data da avaliação -->
                    <td><%=lista.get(i).getDt_update()%></td> <!-- Exibe a data da atualização -->
            </tr>
        <%
            // Incrementa o contador de registros
            n_reg++;                           
        }
        %>
        </table>
        
        <%
            // Exibe a quantidade total de registros no final da tabela
            out.println("<br><br> <b>Registros: </b>" + n_reg + "<br>");       
        %>

    </body>
</html>

