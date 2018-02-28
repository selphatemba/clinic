<%--
  Created by IntelliJ IDEA.
  User: SELPHA
  Date: 15/2/2018
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient/Doctor Booking</title>
    <header><%@include file="Header.jsp"%></header>
</head>
<body>
<%@page import="Pojo.Booking" %>
<%@page import="Pojo.Doctor" %>
<%@page import="Pojo.Patient" %>
<%@page import="Bean.AdminBean" %>
<%@page errorPage="MyErrorPage.jsp" %>


<%!
    Doctor doctor=new Doctor();
    Patient patient=new Patient();
    Booking booking=new Booking();
    AdminBean logic=new AdminBean();
%>

<%
    doctor.setDid(request.getParameter("doctorid"));
    booking.setD(doctor);
    patient.setPid(request.getParameter("patientid"));
    booking.setP(patient);

    if(logic.bookPatientToDoctor(booking)){
        out.print("Successfully booked doctor appointment");
    }else{
        out.print("Not booked in kindly try again");
    }
%>
</body>
<footer><%@include file="Footer.jsp"%></footer>
</html>
