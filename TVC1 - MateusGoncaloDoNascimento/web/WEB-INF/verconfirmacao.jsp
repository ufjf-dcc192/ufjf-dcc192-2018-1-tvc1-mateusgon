<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-listarFuncionamento.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

     <h1> Seus dados cadastrados </h1>
     <p> Nome: ${pessoa.nome} </p>
     <p> Disponibilidade: ${pessoa.disponibilidade} </p>
     <p> Quantidade de Dias: ${pessoa.qtddDias} </p>
     <p> Qualificação: ${pessoa.qualificacao} </p>
     <p> Login: ${pessoa.login} </p>
     <p> Senha: ${pessoa.senha} </p>
     <p> Email: ${pessoa.email} </p>
     
     <a href="controlador.html"> Aperta aqui para voltar </a>
            
<%@include file="jspf/rodape-listarFuncionamento.jspf"%>