<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Management</title>
</head>
<body>
<h1>Student Registration Form</h1>
<h3>Save Student</h3>
<form action="/students/saveStudent" method="post">
    <input type="hidden" name="id" value="${Student.id}"/>
    <table>
        <tbody>
        <tr>
            <td>
                First Name:
                <input type="text" name="firstName" placeholder="firstName" value="${Student.firstName}">
            </td>
        </tr>
        <tr>
            <td>
                Last Name:
                <input type="text" name="lastName" placeholder="lastName" value="${Student.lastName}">
            </td>
        </tr>
        <tr>
            <td>
                Course:
                <input type="text" name="course" placeholder="course" value="${Student.course}">
            </td>
        </tr>
        <tr>
            <td>
                Country:
                <input type="text" name="country" placeholder="country" value="${Student.country}">
            </td>
        </tr>
        </tbody>
    </table>
    <input type="submit" value="Save">
</form>
<a href="/students/home">Back to List</a>
</body>
</html>
