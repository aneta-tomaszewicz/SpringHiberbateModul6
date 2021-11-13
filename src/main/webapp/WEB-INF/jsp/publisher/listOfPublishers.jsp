<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="/publisher/form/add">Dodaj nowego wydawcę</a><br>
<hr>

<c:forEach items="${publishers}" var="p">
    <strong><c:out value="${p.name}"/></strong><br>
    Regon: <c:out value="${p.regon}"/><br>
    Nip: <c:out value="${p.nip}"/><br>
    <a href="edit?idToEdit=${p.id}">Edytuj</a>
    <a href="remove?idToRemove=${p.id}">Usuń</a><br>
    <hr>
</c:forEach>
