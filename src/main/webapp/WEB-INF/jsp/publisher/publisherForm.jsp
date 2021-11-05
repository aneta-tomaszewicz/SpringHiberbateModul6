<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Dodaj nowego wydawcę</h2>

<form:form modelAttribute="publisher">
    <form:hidden path="id"/>
    Nazwa:<form:input path="name"/><br>
    <input type="submit" value="dodaj wydawcę"/>
</form:form>