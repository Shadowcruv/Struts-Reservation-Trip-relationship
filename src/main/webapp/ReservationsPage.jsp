<%--
  Created by IntelliJ IDEA.
  User: HP 840 G3
  Date: 16/10/2023
  Time: 07:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<%--<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>--%>

<html>
    <head>
        <title>Reservations</title>
    </head>
    <body>

        <h1>Make your Reservations</h1>


            <s:form action="addReservationF" method="Post">

                <s:radio name="reservation.clientType" list="{'Individual','company'}" label="ClientType"/>
                <s:radio name="reservation.creditType" list="{'Credit Client','Non Credit Client'}" label="CreditType"/>
<%--                <sx:datetimepicker name="reservation.date" label="Date" displayFormat="dd-MM-yyyy" />--%>
                <s:textfield name="reservation.name" label="Name"></s:textfield>
                <s:textfield name="reservation.contactName" label="ContactName"></s:textfield>
                <s:textfield name="reservation.email" label="email"></s:textfield>
                <s:textfield name="reservation.phoneNo" label="PhoneNo"></s:textfield>
                <s:textfield name="reservation.phoneNo" label="PhoneNo"></s:textfield>

                <s:reset value="Reset" />
                <s:submit value="submit" />
            </s:form>


            <table border="1" width="300">
                <tr>
                    <th>id</th>
                    <th>ClientType</th>
                    <th>CreditType</th>
                    <th>Date</th>
                    <th>Name</th>
                    <th>ContactName</th>
                    <th>Email</th>
                    <th>PhoneNo</th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
                <s:iterator value="reservations" var="reservation">
                    <tr>
                        <td>
                            <s:property value="#reservation.id"/><br/>
                        </td>

                        <td>
                            <s:property value="#reservation.clientType"/><br/>
                        </td>

                        <td>
                            <s:property value="#reservation.creditType"/><br/>
                        </td>
<%--                       <s:iterator value="#reservation.trips" var="dfsxdx">--%>


<%--                       </s:iterator>--%>

<%--                        <td>--%>
<%--                            <s:property value="#reservation.date"/><br/>--%>
<%--                        </td>--%>

                        <td>
                            <s:property value="#reservation.name"/><br/>
                        </td>

                        <td>
                            <s:property value="#reservation.contactName"/><br/>
                        </td>

                        <td>
                            <s:property value="#reservation.email"/><br/>
                        </td>

                        <td>
                            <s:property value="#reservation.phoneNo"/><br/>
                        </td>

                        <td>
                            <a href="update-reservations?reservationId=<s:property value="#reservation.id"/>">
                            <button class="actionBtn">Update</button>
                            </a>
                        </td>
                        <td>
                            <a href="delete-reservations?reservationId=<s:property value="#reservation.id"/>">
                            <button class="actionBtn">Delete</button>
                            </a>
                        </td>
                    </tr>
                </s:iterator>
            </table>

        <table border="1" width="300">
            <tr>
                <th>id</th>
                <th>name</th>
            </tr>
            <s:iterator value="reservation.trips" var="trip">
                <tr>
                    <td>
                    <s:property value="#reservation.id"/><br/>
                    </td>
                    <td>
                    <s:property value="#trip.passengerName"/><br/>
                    </td>
                </tr>
            </s:iterator>
        </table>



        <table border="1" width="300">
            <tr>
                <th>History</th>
                <th>Time</th>
            </tr>
            <s:iterator value="mHistoric" var="history">
                <tr>
                    <td>
                        <s:property value="#history.histories"/><br/>
                    </td>
                    <td>
                        <s:property value="#history.now"/><br/>
                    </td>
                </tr>
            </s:iterator>
        </table>



    </body>
</html>
