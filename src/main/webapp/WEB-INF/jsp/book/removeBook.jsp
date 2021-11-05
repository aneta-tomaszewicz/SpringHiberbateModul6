<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Czy na pewno chcesz usunąć książkę ${book.title}?</h2>

<form method="post">
    <input type="hidden" name="idToRemove" value="${book.id}">
    <button type = "submit" value="yes" name = "confirmed">Tak</button>
    <button type = "submit" value="no" name = "confirmed">Nie</button>
</form>

