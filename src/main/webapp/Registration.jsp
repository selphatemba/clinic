

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
    <h1 class="well">Registration Form</h1>
    <div class="col-lg-12 well">
        <div class="row">
            <form class="form-signin" id="form" action="/ClinicMis2/registration" method="post" onsubmit="return checkForm(this);">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <label>First Name</label>
                            <input type="text" placeholder="Enter First Name Here.." class="form-control" name="fname">
                        </div>
                        <div class="col-sm-6 form-group">
                            <label>Last Name</label>
                            <input type="text" placeholder="Enter Last Name Here.." class="form-control" name="lname">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 form-group">
                            <label>Town</label>
                            <input type="text" placeholder="Town Name" class="form-control" name="town">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <label>Gender</label>
                            <select name="gender">
                                <option value="Female">Female</option>
                                <option value="Male">Male</option>
                            </select>
                        </div>
                        <div class="col-sm-6 form-group">
                            <label>Title</label>
                            <select name="title">
                                <option value="Doctor">Doctor</option>
                                <option value="Nurse" >Nurse</option>
                                <option value="LabTechnician">Lab Technician</option>
                                <option value="Receptionist">Receptionist</option>
                            </select>
                        </div>
                        <div class="col-sm-6 form-group">
                            <label>Job ID</label>
                            <input type="text" placeholder="Enter Your Job ID" class="form-control" name="jobid" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Phone Number</label>
                        <input type="text" placeholder="Enter Phone Number Here.." class="form-control" name="phonenumber">
                    </div>
                    <div class="form-group">
                        <label>Email Address</label>
                        <input type="text" placeholder="Enter Email Address Here.." class="form-control" name="email" required>
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" required  placeholder="Enter Password Here.." class="form-control" name="password">
                    </div>
                    <div class="form-group">
                        <label>Confirm Password</label>
                        <input type="password" placeholder="Confirm Your Password.." class="form-control" name="password2">
                    </div>
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">register</button>
                    <div class="row">
                        <div class="col-xs-6">
                            <a href="index.jsp" id="register-form-link">Login</a>
                        </div>
                    </div>
                    <hr>
                </div>
            </form>
        </div>
    </div>
    </div>
</div>
<%@include file="Footer.jsp"%>
</body>
</html>



