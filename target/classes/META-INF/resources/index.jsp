
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>login page</title>
    <center><%@include file="Header.jsp"%></center>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/good.js"></script>
</head>
<body>
<div class="container">
    <div class="card card-container">
        <form class="form-signin" action="/ClinicMis2/ws/user/login" method="post">
            UserID:<input type="text" id="jobID" class="form-control" placeholder="User ID" required name="userid"/><br>
            Password:<input type="Password" id="inputPassword" class="form-control" placeholder="password"  name="password" required/><br>
            <div id="remember" class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">login</button>
            <div class="row">
                <div class="col-xs-6">
                    <a href="Registration.jsp" id="register-form-link">Register</a>
                </div>
            </div>
            <hr>
        </form>
    </div>
</div>
<%@include file="Footer.jsp"%>
</body>
</html>
