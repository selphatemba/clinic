<%--
  Created by IntelliJ IDEA.
  User: SELPHA
  Date: 15/2/2018
  Time: 8:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>patient booking</title>
<center><%@include file="Header.jsp"%></center>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/good.js"></script>
</head>
<body>
<div class="container">
    <div class="card card-container">
        <h2>Patient/Doctor Booking</h2>
        <form class="form-signin" action="/ClinicMis2/ws/admin/booking" method="post">
            Doctor ID:<input type="text" id="jobID" class="form-control" placeholder="Doctor ID" required name="doctorid"/><br>
            Patient ID:<input type="text" id="inputPassword" class="form-control" placeholder="Patient ID"  name="patientid" required/><br>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Book</button>>
        </form>
    </div>
</div>
<%@include file="Footer.jsp"%>
</body>
</html>
