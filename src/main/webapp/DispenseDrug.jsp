<%--
  Created by IntelliJ IDEA.
  User: SELPHA
  Date: 27/2/2018
  Time: 8:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PHARMACY</title>
</head>
<body>
<form action="PayForService.jsp" method="post">

    PatientID:<input type="text" name="PatientID"/><br/><br/>
    Medicine:<input type="text" placeholder="Medication" name="medicine"/><br/><br/>
    <input type="submit" value="Dispense"/>
</form>
</body>
</html>
