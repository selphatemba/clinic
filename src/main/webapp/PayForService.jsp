<%--
  Created by IntelliJ IDEA.
  User: SELPHA
  Date: 15/2/2018
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CASHIER</title>
    <header><%@include file="Header.jsp"%></header>
</head>
<body>
<%@page import="Entities.Payment" %>
<%@page import="Bean.BeanImplementation.AdminBean" %>
<%@ page import="Entities.Service" %>
<%@ page import="Entities.Patient" %>
<%@page errorPage="MyErrorPage.jsp" %>

<%!
    Payment pay=new Payment();
    AdminBean logic=new AdminBean();
    Patient p=null;
%>
<%
    p.setPid(request.getParameter("PatientID"));
    pay.setP(p);
    pay.setS((Service.valueOf(request.getParameter("service"))));
    pay.setAmount(Double.parseDouble(request.getParameter("Amount")));

    if(logic.payForServices(pay)){
        out.print("Successfully paid");
    }else{
        out.print("Not successful");
    }
%>



</body>
<footer><%@include file="Footer.jsp"%></footer>
</html>
