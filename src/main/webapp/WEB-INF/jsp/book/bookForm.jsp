<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Dodaj nową książkę</h2>

<form:form modelAttribute="book" action="/book/form/save">
    Tytuł: <form:input path="title"/><br/>
    Rating: <form:input path="rating"/><br/>
    Opis:<form:textarea cols="50" rows="20" path="description"/><br/>
    Wydawca: <form:select path="publisher.id" items="${publishers}"  itemLabel="name" itemValue="id"/><br/>
    Autor: <form:select multiple="true" path="authors" items="${authors}"  itemLabel="fullName" itemValue="id"/><br/>
    <input type="submit" value="dodaj książkę"/>


</form:form>

