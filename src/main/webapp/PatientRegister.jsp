

<html>
<head>
    <center><%@include file="Header.jsp"%></center>
    <link rel="stylesheet"  href="css/bootstrap.min.css" id="bootstrap-css">
    <link rel="stylesheet" href="css/registration.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/registration.js"></script>
    <script src="jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="container">
    <div class="card card-container">
        <h1 class="well">Patient Registration</h1>
        <div class="col-lg-12 well">
            <div class="row">
                <form class="form-signin" id="form" action="/ClinicMis2/registration" method="post" onsubmit="return checkForm(this);">
                    <div class="col-sm-12">
                            <div class="col-sm-6 form-group">
                                <label>First Name</label>
                                <input type="text" placeholder="Enter First Name Here.." class="form-control" name="fname">
                            </div>
                            <div class="col-sm-6 form-group">
                                <label>Second Name</label>
                                <input type="text" placeholder="Enter Last Name Here.." class="form-control" name="lname">
                            </div>
                        <div class="row">
                            <div class="col-sm-4 form-group">
                                <label>ID Number</label>
                                <input type="text" placeholder="ID Number" class="form-control" name="idnumber">
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Patient ID</label>
                                <input type="text" placeholder="Patient ID" class="form-control" name="patientid">
                            </div>
                        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">register</button>
                        <hr>
                    </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="Footer.jsp"%>
</body>
</html>



