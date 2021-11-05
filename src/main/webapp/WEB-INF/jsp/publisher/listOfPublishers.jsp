<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${publishers}" var="p">
    <strong><c:out value="${p.name}"/></strong>
    <a href="edit?idToEdit=${p.id}">Edytuj</a>
    <a href="remove?idToRemove=${p.id}">Usuń</a><br>
    <hr>
</c:forEach>
<a href="/publisher/form/add">Dodaj nowego wydawcę</a>