<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:out value="${student.firstName} ${student.lastName} ${student.gender}"/><br/>
<c:out value="${student.country}"/><br/>
<c:out value="${student.notes}"/><br/>
<c:out value="mailing: ${student.mailingList}"/><br/>
programming:
<c:forEach items="${student.programmingSkills}" var="p">
    <c:out value="${p}"/>
</c:forEach><br/>
hobbies:
<c:forEach items="${student.hobbies}" var="h">
    <c:out value="${h}"/>
</c:forEach>





