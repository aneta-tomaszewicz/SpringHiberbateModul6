<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <style>
        .error {
            color: red;
            border: 2px solid;
        }
    </style>
</head>

<h2>Dodaj nową książkę</h2>


<form:form modelAttribute="book" >
    <form:hidden path="id"/>
    Tytuł: <form:input path="title"/><br/>
    <form:errors path ="title" cssClass ="error" /><br>

    Rating: <form:input path="rating"/><br/>
    <form:errors path ="rating"/><br>

    Opis:<form:textarea cols="50" rows="20" path="description"/><br/>
    <form:errors path ="description"/><br>

    Wydawca: <form:select path="publisher.id" items="${publishers}"  itemLabel="name" itemValue="id"/><br/>
    <form:errors path ="publisher"/><br>

    Autor: <form:select multiple="true" path="authors" items="${authors}"  itemLabel="fullName" itemValue="id"/><br/>
    <form:errors path ="authors"/><br>

    Liczba Stron:<form:input path="pages" type="number"/><br>
    <form:errors path ="pages"/><br>


    <input type="submit" value="Zapisz"/>


</form:form>

