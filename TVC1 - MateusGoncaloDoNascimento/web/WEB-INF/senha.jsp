<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-listarFuncionamento.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <form method="post"> 
            <p> Login: </p>
            <input type="text" name="login" id="login"/>
            <p> Senha </p>
            <input type="text" name="senha" id="senha"/>
            <input type="hidden" value="${pessoa.id}" id="pessoa"/>
            <input type="hidden" value="${idTipo}" id="tipoP"/>
        <p> <input type="hidden" name="operacaoVerTodosInscritos" value="incluir">
            <input type="submit" value="Conferir"> </p>
        </form>

<%@include file="jspf/rodape-listarFuncionamento.jspf"%>