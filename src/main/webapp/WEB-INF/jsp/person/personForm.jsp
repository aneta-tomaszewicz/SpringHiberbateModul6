<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form:form method="post" modelAttribute="person">

    Login:<form:input path="login"/><br/>
    Password:<form:input path="password"/><br/>
    Email:<form:input type = "email" path="email"/><br/>

    <input type="submit" value="Wyślij"><br/>

</form:form>





<%-- formularz do obsługi @RequestParam
<form method="post">
    Login:<input type="text" name="login"><br/>
    Password:<input type="password" name="password"><br/>
    Email:<input type="email" name="email"><br/>

    <input type="submit" value="Wyślij"><br/>
</form>--%>
