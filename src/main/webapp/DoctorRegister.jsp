<%--
  Created by IntelliJ IDEA.
  User: SELPHA
  Date: 15/2/2018
  Time: 7:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DOCTOR REGISTRATION</title>
</head>
<body>
<h2>Enter New Doctor's details to register</h2>
<form action="Management2.jsp" method="post">

    FirstName:<input type="text" name="firstname"/><br/><br/>
    SecondName:<input type="text" name="secondname"/><br/><br/>
    DoctorID:<input type="text" required name="Did"/><br/><br/>
    <input type="submit" value="register"/>

</form>
</body>
</html>
