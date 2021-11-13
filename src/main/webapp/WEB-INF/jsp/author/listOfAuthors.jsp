<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="/author/form/add">Dodaj nowego autora</a><br>
<hr>
<c:forEach items="${authors}" var="a">
    <strong><c:out value="${a.firstName} ${a.lastName}"/></strong><br>
    <c:out value="${a.pesel} "/><br>
    <c:out value="${a.email} "/><br>

    <a href="edit?idToEdit=${a.id}">Edytuj</a>
    <a href="remove?idToRemove=${a.id}">Usuń</a>

    <hr>
</c:forEach>
