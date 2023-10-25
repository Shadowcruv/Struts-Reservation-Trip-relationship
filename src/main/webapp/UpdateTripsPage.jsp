<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: HP 840 G3
  Date: 16/10/2023
  Time: 08:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update-Trip</title>
    <sx:head/>
</head>
<body>
    <h1>Update Trip</h1>

    <s:form action="updated-trips" method="Post">
        <s:textfield name="reservationId" label="Reservation Id" readonly="true"></s:textfield>
<%--        <s:radio name="trips.reservation.clientType" list="{'Individual','company'}" label=" Reservation ClientType" readonly="true" />--%>
<%--        <s:radio name="trips.reservation.creditType" list="{'Credit Client','Non Credit Client'}" label="Reservation CreditType" readonly="true" />--%>
<%--        <sx:datetimepicker name="trips.reservation.date" label="Reservation Date" displayFormat="dd-MM-yyyy"/>--%>
<%--        <s:textfield name="theName" label="Reservation Name" ></s:textfield>--%>
<%--        <s:textfield name="trips.reservation.contactName" label="Reservation ContactName" readonly="true"></s:textfield>--%>
<%--        <s:textfield name="trips.reservation.email" label="Reservation email" readonly="true"></s:textfield>--%>
<%--        <s:textfield name="trips.reservation.phoneNo" label="Reservation PhoneNo" readonly="true"></s:textfield><br/><br/>--%>


        <s:textfield name="tripId" label="Trip Id" readonly="true"></s:textfield>
        <s:textfield name="trips.passengerName" label="PassengerName"></s:textfield>
        <s:textfield name="trips.departure" label="Departure"></s:textfield>
        <sx:datetimepicker name="pickUpDate" label="PickUpDate" displayFormat="dd-MM-yyyy" />
        <s:textfield name="trips.noOfPassenger" label="NoOfPassenger"></s:textfield>
        <s:textfield name="trips.phone" label="Phone"></s:textfield>
        <s:textfield name="trips.email" label="email"></s:textfield>
        <s:textfield name="trips.destination" label="Destination"></s:textfield>
        <s:textfield name="trips.possibleStops" label="PossibleStops"></s:textfield>
        <sx:datetimepicker name="endDate" label="EndDate" displayFormat="dd-MM-yyyy" />
        <s:reset value="Reset" />
        <s:submit value="submit" />
    </s:form>

</body>
</html>
