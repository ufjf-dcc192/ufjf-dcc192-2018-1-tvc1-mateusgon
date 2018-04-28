<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-listarFuncionamento.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <form method="post"> 
            <p> Login: </p>
            <input type="text" name="login" id="login"/>
            <p> Senha </p>
            <input type="text" name="senha" id="senha"/>
        <p> <input type="hidden" name="operacaoSenha" value="incluir">
            <input type="submit" value="Conferir"> </p>
        </form>

<%@include file="jspf/rodape-listarFuncionamento.jspf"%>