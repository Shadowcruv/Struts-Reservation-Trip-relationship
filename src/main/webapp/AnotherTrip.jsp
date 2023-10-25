<%--
  Created by IntelliJ IDEA.
  User: HP 840 G3
  Date: 16/10/2023
  Time: 08:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>



<html>
<head>
    <title>Trips</title>
    <sx:head/>
</head>
<body>

<h1>Add Another Trip</h1>


<s:form action="add-another-trip" method="Post">
    <s:textfield name="trips.reservation.id" label="Reservation Id" readonly="true"></s:textfield>
    <s:radio name="trips.reservation.clientType" list="{'Individual','company'}" label=" Reservation ClientType" readonly="true" />
    <s:radio name="trips.reservation.creditType" list="{'Credit Client','Non Credit Client'}" label="Reservation CreditType" readonly="true" />
<%--    <sx:datetimepicker name="trips.reservation.date" label="Reservation Date" displayFormat="dd-MM-yyyy"/>--%>
    <s:textfield name="trips.reservation.name" label="Name" readonly="true"></s:textfield>
    <s:textfield name="trips.reservation.contactName" label="Reservation ContactName" readonly="true"></s:textfield>
    <s:textfield name="trips.reservation.email" label="Reservation email" readonly="true"></s:textfield>
    <s:textfield name="trips.reservation.phoneNo" label="Reservation PhoneNo" readonly="true"></s:textfield><br/><br/>


    <s:textfield name="trips.passengerName" label="PassengerName"></s:textfield>
    <s:textfield name="trips.departure" label="Departure"></s:textfield>
    <sx:datetimepicker name="pickUpDate" label="PickUpDate" displayFormat="dd-MM-yyyy HH:mm" />
    <s:textfield name="trips.noOfPassenger" label= "NoOfPassenger"></s:textfield>
    <s:textfield name="trips.phone" label="Phone"></s:textfield>
    <s:textfield name="trips.email" label="Email"></s:textfield>
    <s:textfield name="trips.destination" label="Destination"></s:textfield>
    <s:textfield name="trips.possibleStops" label="PossibleStops"></s:textfield>
    <sx:datetimepicker name="endDate" label="EndDate" displayFormat="dd-MM-yyyy HH:mm" />
    <s:reset value="Reset" />
    <s:submit value="submit" />
</s:form>


<table border="1" width="300">
    <tr>
        <th>PassengerName</th>
        <th>Departure</th>
<%--        <th>PickUpDate</th>--%>
        <th>NoOfPassengers</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Destination</th>
        <th>PossibleStops</th>
        <th>ReservationId</th>
        <th>Name</th>
<%--        <th>EndDate</th>--%>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <s:iterator value="tripsList" var="trips">
        <tr>
            <td>
                <s:property value="#trips.passengerName"/><br/>
            </td>

            <td>
                <s:property value="#trips.departure"/><br/>
            </td>

<%--            <td>--%>
<%--                <s:property value="#trips.pickUpDate"/><br/>--%>
<%--            </td>--%>

            <td>
                <s:property value="#trips.noOfPassengers"/><br/>
            </td>

            <td>
                <s:property value="#trips.phone"/><br/>
            </td>

            <td>
                <s:property value="#trips.email"/><br/>
            </td>

            <td>
                <s:property value="#trips.destination"/><br/>
            </td>

            <td>
                <s:property value="#trips.possibleStops"/><br/>
            </td>


            <td>
                <s:property value="#trips.reservation.id"/><br/>
            </td>

            <td>
                <s:property value="#trips.reservation.name"/><br/>
            </td>


<%--            <td>--%>
<%--                <s:property value="#trips.endDate"/><br/>--%>
<%--            </td>--%>
            <td>
                <a href="update-trips?tripId=<s:property value="#trips.tripId"/>">
                    <button class="actionBtn">Update</button>
                </a>
            </td>
            <td>
                <a href="delete-trips?tripId=<s:property value="#trips.tripId"/>">
                    <button class="actionBtn">Delete</button>
                </a>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
