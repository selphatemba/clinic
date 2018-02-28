
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Pojo.Patient"%>
<%@ page import="javax.inject.Inject" %>
<%@ page import="javax.inject.Named" %>
<%@ page import="Bean.PatientBeanI" %>
<%@ page import="Bean.PatientBean" %>
<%@include file="Header.jsp"%>


<%!
    PatientBean patientBeanI=null;
    Patient patient=new Patient();
%>

<%
    if(request.getParameter("firstname")!=null) {
        if (request.getAttribute("patientBeanI") != null) {
            patientBeanI = (PatientBean) request.getAttribute("patientBeanI");
            patient.setFname(request.getParameter("firstname"));
            patient.setSname(request.getParameter("secondname"));
            patient.setIDnumber(Integer.parseInt(request.getParameter("IDnumber")));
            patient.setPid(request.getParameter("Pid"));

            if (patientBeanI.registerPatient(patient)) {
                out.print("Successfully registered");
            } else {
                out.print("Not logged in kindly try again");
            }
        }
    }
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PATIENT REGISTER</title>
    <h1>Capture Patient's details to register</h1>
</head>
<body>
<form action="/ClinicMis2/registerpatient" method="post">

    FirstName:<input type="text" name="firstname"/><br/><br/>
    SecondName:<input type="text" name="secondname"/><br/><br/>
    IDNumber:<input type="number" name="IDnumber"/><br/><br/>
    PatientID:<input type="text" required name="Pid"/><br/><br/>
    <input type="submit" value="register"/>

</form>

</body>
<footer><%@include file="Footer.jsp"%></footer>

</html>
