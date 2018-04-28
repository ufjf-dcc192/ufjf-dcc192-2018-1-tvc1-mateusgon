<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-listarFuncionamento.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <h1> Inscrição </h1>
        <form method="post">    
            <p> Função: </p>
            <select id="itens" name="itens">
                <option value="0"> Intercambista </option>
                <option value="1"> Docente </option>
                <option value="2"> TAE </option>
                <option value="3"> Aluno </option>
            </select>
            <p> Nome: </p>
            <input type="text" name="nome" id="nome"/>
            <p> Período disponível (Por exemplo: Dia 1 de abril até 15 de abril) </p>
            <input type="text" name="disponibilidade" id="disponibilidade"/>
            <p> Quantidade de dias disponíveis (Por exemplo: 15) </p>
            <input type="text" name="dias" id="dias"/>
            <p> <input type="hidden" name="operacaoAdicionarParticipante" value="incluir">
                <input type="submit" value="Adicionar"> </p>
        </form>
            
<%@include file="jspf/rodape-listarFuncionamento.jspf"%>