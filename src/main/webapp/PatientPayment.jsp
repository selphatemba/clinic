<%--
  Created by IntelliJ IDEA.
  User: SELPHA
  Date: 15/2/2018
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CASHIER</title>
</head>
<body>
<form action="PayForService.jsp" method="post">

    PatientID:<input type="text" name="PatientID"/><br/><br/>
    Service:<input type="text" placeholder="Consultation,LabTest,Medicine" name="service"/><br/><br/>
    Amount:<input type="number" name="Amount"/><br/><br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>