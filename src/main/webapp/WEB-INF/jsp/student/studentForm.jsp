<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<form:form metod ="post" modelAttribute="student" action="/student/save">


    firstName:<form:input path="firstName"/><br/>
    lastName: <form:input path="lastName"/><br/>
    gender:<br/>
    M:<form:radiobutton path="gender" value="M"/><br/>
    F:<form:radiobutton path="gender" value="F"/><br/>
    country:<br/>
    <form:select path="country"><br/>
    <form:option value="-" label="--Please Select--"/><br/>
    <form:options items="${countries}"/>
</form:select><br/>
    notes: <form:textarea path="notes" rows="3" cols="20" /><br/>
    mailingList: <form:checkbox path="mailingList"/><br/>
    programmingSkills: <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/><br/>
    mailingList: <form:checkbox path="mailingList"/><br/>
    hobbies:<form:checkboxes path="hobbies" items="${hobbies}"/><br/>

    <input type="submit" value="Send"></br>

</form:form>

