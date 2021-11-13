<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Dodaj nowego wydawcę</h2>

<form:form modelAttribute="publisher">
    <form:hidden path="id"/>
    Nazwa:<form:input path="name"/><br>
    <form:errors path ="name"/><br>

    Regon:<form:input path="regon"/><br>
    <form:errors path ="regon"/><br>

    Nip:<form:input path="nip"/><br>
    <form:errors path ="nip"/><br>

    <input type="submit" value="zapisz"/>
</form:form>