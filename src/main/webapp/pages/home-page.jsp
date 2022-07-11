<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Student Registration Management</title>
</head>
<body>
<h1>Student Registration Management</h1>
<form action="/students/addStudent" method="post">
    <input type="submit" value="Add Student">
    <table>
        <thead>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Course</th>
        <th>Country</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach items="${Students}" var="student">
            <tr>
                <td><c:out value="${student.firstName}"/></td>
                <td><c:out value="${student.lastName}"/></td>
                <td><c:out value="${student.course}"/></td>
                <td><c:out value="${student.country}"/></td>
                <td>
                    <a href="/students/updateStudent?id=${student.id}">Update</a> |
                    <a href="/students/deleteStudent?id=${student.id}"
                       onclick="if(!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
