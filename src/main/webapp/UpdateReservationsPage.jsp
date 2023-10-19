<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: HP 840 G3
  Date: 16/10/2023
  Time: 08:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update-Reservation</title>
</head>
<body>
    <h1>Update Reservation</h1>

    <s:form action="updated-reservations">

        <s:textfield name="reservationId" label="Reservation Id" readonly="true"></s:textfield>
        <s:radio name="reservation.clientType" list="{'Individual','company'}" label="ClientType"/>
        <s:radio name="reservation.creditType" list="{'Credit Client','Non Credit Client'}" label="CreditType"/>
        <sx:datetimepicker name="reservation.date" label="Date" displayFormat="dd-MM-yyyy" />
        <s:textfield name="reservation.name" label="Name"></s:textfield>
        <s:textfield name="reservation.contactName" label="ContactName"></s:textfield>
        <s:textfield name="reservation.email" label="email"></s:textfield>
        <s:textfield name="reservation.phoneNo" label="PhoneNo"></s:textfield>
        <s:reset value="Reset" />
        <s:submit value="submit" />
    </s:form>

</body>
</html>
