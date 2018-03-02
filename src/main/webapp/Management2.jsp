<%--
  Created by IntelliJ IDEA.
  User: SELPHA
  Date: 15/2/2018
  Time: 7:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>DOCTOR REGISTRATION</title>
    <header><%@include file="Header.jsp"%></header>
</head>
<body>
<%@ page import="Pojo.Doctor" %>
<%@ page import="Bean.BeanImplementation.AdminBean" %>
<%@ page import="javax.inject.Inject" %>
<%@ page import="javax.inject.Named" %>
<%@ page import="Bean.DoctorBeanI" %>
<%@page errorPage="MyErrorPage.jsp" %>
<%!
    @Inject @Named ("doctorbean")
    private DoctorBeanI doctorBeanI;
    Doctor doctor=new Doctor();
%>

<%
    doctor.setFname(request.getParameter("firstname"));
    doctor.setSname(request.getParameter("secondname"));
    doctor.setDid(request.getParameter("Did"));

    if(doctorBeanI.registerDoctor(doctor)){
        out.print("Successfully registered");
    }else{
        out.print("Not logged in kindly try again");
    }
%>


</body>
<footer><%@include file="Footer.jsp"%></footer>
</html>
