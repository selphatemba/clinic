<%--
  Created by IntelliJ IDEA.
  User: SELPHA
  Date: 14/2/2018
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <center><%@include file="Header.jsp"%></center>
    <meta charset="UTF-8">
    <title>PATIENT REGISTER</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/custom.css.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/good.js"></script>
</head>
<body>
<div class="container">
    <div class="card card-container">
        <h1>Register Patient</h1>
<form  class="form-signin" action="Management.jsp" method="post">
<div class="row">
    <div class="col-sm-6 form-group">
    FirstName:<input type="text" class="form-control" name="firstname"/><br/><br/>
    SecondName:<input type="text" class="form-control" name="secondname"/><br/><br/>
    </div>
</div>
    IDNumber:<input type="number" class="form-control" name="IDnumber"/><br/><br/>
    PatientID:<input type="text" class="form-control" required name="Pid"/><br/><br/>
    <div class="row">
        <div class="col-xs-6">
            <a href="Management.jsp" id="register-form-link">Register</a>
        </div>
    </div>
    <input type="submit" value="register"/>

</form>
    </div>
    </div>

</body>
</html>