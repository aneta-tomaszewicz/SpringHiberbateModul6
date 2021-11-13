<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Dodaj nowego autora</h2>

<form:form modelAttribute="author">
    <form:hidden path="id"/>

    Imię: <form:input path="firstName"/><br>
    <form:errors path="firstName"/><br>

    Nazwisko: <form:input path="lastName"/><br>
    <form:errors path="lastName"/><br>

    Pesel: <form:input path="pesel"/><br>
    <form:errors path="pesel"/><br>

    Email:<form:input path="email"/><br>
    <form:errors path="email"/><br>

    <input type="submit" value="zapisz">
</form:form>