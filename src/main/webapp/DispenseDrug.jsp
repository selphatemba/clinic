<%--
  Created by IntelliJ IDEA.
  User: SELPHA
  Date: 27/2/2018
  Time: 8:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>PHARMACY</title>
<center><%@include file="Header.jsp"%></center>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/good.js"></script>
</head>
<body>
<div class="container">
    <div class="card card-container">
        <h2>Dispense Drug</h2><br><br>
        <form class="form-signin" action="PayForService.jsp" method="post">
            Patient ID:<input type="text" id="jobID" class="form-control" placeholder="Patient ID" required name="PatientID"/><br>
            Medication:<input type="text" id="inputPassword" class="form-control" placeholder="Medication"  name="medicine" required/><br>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Dispense</button>
            <hr>
        </form>
    </div>
</div>
<%@include file="Footer.jsp"%>
</body>
</html>
