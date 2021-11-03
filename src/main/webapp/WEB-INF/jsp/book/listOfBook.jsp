<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${books}" var="b">
    <strong><c:out value="${b.title}:${b.publisher.name}"/></strong><br>
    <c:out value="${b.description}"/><br>
    <c:forEach items="${b.authors}" var ="a" varStatus="loop">
        <strong><c:out value="${a.firstName} ${a.lastName}"/></strong><c:if test="${loop.index + 1 lt b.authors.size()}"></c:if>
    </c:forEach>

    <hr>
</c:forEach>
<a href="/book/form/show">Dodaj nową książkę</a>


