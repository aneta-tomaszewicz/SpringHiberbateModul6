<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${books}" var="b">
    <strong><c:out value="${b.title}:${b.publisher.name}"/></strong><br>
    <c:out value="${b.description}"/><br>
    <c:forEach items="${b.authors}" var ="a" varStatus="loop">
        <strong><c:out value="${a.firstName} ${a.lastName}"/></strong><c:if test="${loop.index + 1 lt b.authors.size()}"></c:if><br>
    </c:forEach>
    <a href="edit?idToEdit=${b.id}">Edytuj </a>
    <a href="remove?idToRemove=${b.id}">Usuń </a>

    <hr>
</c:forEach>
<a href="/book/form/add">Dodaj nową książkę</a>


