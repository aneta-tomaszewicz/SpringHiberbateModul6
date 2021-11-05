<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Czy na pewno chcesz usunąć autora ${author.firstName} ${author.lastName}</h2>

<form method="post">
    <input type =hidden name="idToRemove" value="${author.id}">
    <button type="submit" value="yes" name="confirmed">Tak</button>
    <button type="submit" value="no" name="confirmed">Nie</button>
</form>