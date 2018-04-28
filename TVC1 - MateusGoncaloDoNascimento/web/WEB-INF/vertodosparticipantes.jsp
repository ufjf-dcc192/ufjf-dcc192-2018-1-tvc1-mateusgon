<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-listarFuncionamento.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1> Participantes </h1>
<table border=1px>
    <tr>
        <td> Nome </td>
        <td> Email </td>
        <td> Modificar </td>
        <td> Excluir </td>
    </tr>
            <c:forEach items="${estudantes}" var="estudantes" >
                <tr>
                    <td> ${estudantes.nome} </td>
                    <td> ${estudantes.email} </td>
                    <td> ${estudantes.disponibilidade} </td>
                    <td> ${estudantes.qtddDias} </td>
                </tr>
            </c:forEach>
            <c:forEach items="${taes}" var="taes" >
                <tr>
                    <td> ${taes.nome} </td>
                    <td> ${taes.email} </td>
                    <td> ${taes.disponibilidade} </td>
                    <td> ${taes.qtddDias} </td>
                </tr>
            </c:forEach>
            <c:forEach items="${intercambistas}" var="intercambistas" >
                <tr>
                    <td> ${intercambistas.nome} </td>
                    <td> ${intercambistas.email} </td>
                    <td> ${intercambistas.disponibilidade} </td>
                    <td> ${intercambistas.qtddDias} </td>
                </tr>
            </c:forEach>
            <c:forEach items="${docentes}" var="docentes" >
                <tr>
                    <td> ${docentes.nome} </td>
                    <td> ${docentes.email} </td>
                    <td> ${docentes.disponibilidade} </td>
                    <td> ${docentes.qtddDias} </td>
                </tr>
            </c:forEach>
</table>
            
<%@include file="jspf/rodape-listarFuncionamento.jspf"%>