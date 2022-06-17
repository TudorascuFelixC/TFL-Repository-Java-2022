<%-- 
    Document   : ValidatorGate
    Author     : Tudorascu Felix
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model_TFL_Underground.Ticket"%>
<%@page import="java.io.StringReader"%>
<%@page import="javax.xml.bind.Unmarshaller"%>
<%@page import="Model_TFL_Underground.Gate"%>
<%@page import="Model_TFL_Underground.ValidatorTicket"%>
<%@page import="javax.xml.bind.JAXBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    Date currentTime = new Date();
    System.out.println(formatter.format(currentTime));

    out.print("<h1>" + formatter.format(currentTime) + "</h1>");

    String ticktToUnmarshall = request.getParameter("ticktToUnmarshall");

    String travellerfrom = request.getParameter("travellerfrom");
    if (travellerfrom == null || travellerfrom.isEmpty()) {
        travellerfrom = "4";
    }

    boolean openGate = false;

    out.print("<h1>" + ticktToUnmarshall + "</h1>");


            %>
            <br>
            
        <h1> Validate if the Gate can be Open !! </h1>
        <br>
        
        <form action="ValidatorGate.jsp" method="post">
            <label>Current Time in UK: </label>
            <input type="text" name="currentTime" value="<%= formatter.format(currentTime)%>">
            
            <br>
            
            <label> You are a traveller from: </label>
            <input type="text" name="travellerfrom" value"<%= travellerfrom%>">
            <br>
            <label>Enter your XML ticket code down bellow:  </label><br>
            <textarea name="ticketToUnmarshall" rows="15" cols="130"></textarea>
            <br>
            
            <button type="submit"> Check your ticket </button>
        </form>
            
            <%
                String ticketUnmarshall = null;
                Gate new_gate = null;
                ValidatorTicket validator = new ValidatorTicket();
                
                if(request.getParameter("ticketString") != null){
                    ticketUnmarshall = request.getParameter("ticketString");
                    
                    JAXBContext context = JAXBContext.newInstance(Ticket.class);
                    Unmarshaller unmarshaller = context.createUnmarshaller();
                    StringReader reader = new StringReader(ticketUnmarshall);
                    Ticket ticketUnmarshalled = (Ticket) unmarshaller.unmarshal(reader);
                    new_gate.enter(ticketUnmarshall);
                    out.print(ticketUnmarshalled.getTo_station());
                    out.print("H1" + Integer.parseInt(ticketUnmarshalled.getTo_zone()) + "</h1>");
                }
                
                %>
                
                <br>
                <% if (openGate) { %>
                <div style="color:green;">The Gate is OPEN NOW ! Please go in! Have a nice day!</div>
                <%} else{ %>
                <div style=""color:red;">The Gate is CLOSED ! Please buy a valid ticket!  Have a nice day!</div>
                <%} %>
        
        
        
    </body>
</html>
