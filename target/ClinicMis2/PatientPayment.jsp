<%--
  Created by IntelliJ IDEA.
  User: SELPHA
  Date: 15/2/2018
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>patient payment</title>
<center><%@include file="Header.jsp"%></center>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/good.js"></script>
</head>
<body>
<div class="container">
    <div class="card card-container">
        <form class="form-signin" action="/ClinicMis2/ws/admin/payment" method="post">
            PatientID:<input type="text" id="jobID" class="form-control" placeholder="Patient ID" required name="PatientID"/><br>
            Service:<input type="text" id="inputPassword" class="form-control" placeholder="Consultation,LabTest,Medicine"  name="service" required/><br>
            Amount:<input type="text" id="jobID" class="form-control" placeholder="Amount" required name="Amount"/><br>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Pay</button>

            <hr>
        </form>
    </div>
</div>
<%@include file="Footer.jsp"%>
</body>
</html>
