<%-- 
    Document   : TFL_JSP
    Author     : Tudorascu Felix
--%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ControllersClient_TFL.TicketGenerator_TFL_Underground"%>
<%@page import="Model_TFL_Underground.Ticket"%>
<%@page import ="java.util.List"%>
<%@page import ="Model_TFL_Underground.Station"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="TFL_JSP.jsp" id="userform">
            <label for="label_fromstation">From Station:</label>
            <select name="fromstation" id="dropdownStation">  
        <%
            List<Station> listOfStation_TFL_From = ClientConsumerServiceRestful_TFL_Underground.Consumer_TFL_Underground.getStations();
            
            for( int i = 0; i < listOfStation_TFL_From.size(); i++ ) {
                out.print("<option value=" + i + ">" + listOfStation_TFL_From.get(i).getStationname() + "</option>");
            }
            
        %>
        </select>
        <br>
        <br>

            
            
            <label for="label_tostation">To Station:       </label>
            <select name="tostation" id="dropdownStation">  
        <%
            List<Station> listOfStation_TFL_TO = ClientConsumerServiceRestful_TFL_Underground.Consumer_TFL_Underground.getStations();
            
            for( int i = 0; i < listOfStation_TFL_TO.size(); i++ ) {
                out.print("<option value=" + i + ">" + listOfStation_TFL_TO.get(i).getStationname() + "</option>");
            }
            
        %>
        </select>
        <br>
        <br>
            Ticket End Date: <input type="date" name="date">
            <br>
            <br>
            <input type="submit" value="Create XML Ticket">
            
        </form>
        <br>
        
        
        <%
            String xml_ticket = null;
            if(request.getParameter("fromstation") !=null &&
                     request.getParameter("tostation") !=null &&
                     request.getParameter("date") !=null)
            {
                
               int fromZone= Integer.parseInt(request.getParameter("fromstation"));
               
               int toZone= Integer.parseInt(request.getParameter("tostation"));
               
               SimpleDateFormat ParsedDate_TFL = new SimpleDateFormat("yyyy-MM-dd");
               
               String ExpiredDate = request.getParameter("date");
               
               Date ExpiredDateParsed = ParsedDate_TFL.parse(ExpiredDate);
               
                Ticket ticket = new Ticket( listOfStation_TFL_From.get(fromZone).getStationname(),                       
                                            listOfStation_TFL_TO.get(toZone).getStationname(),
                        
                                            String.valueOf(listOfStation_TFL_From.get(fromZone).getZone()),                      
                                            String.valueOf(listOfStation_TFL_TO.get(toZone).getZone()), 

                        
                        
                                            false, false, ExpiredDateParsed);
                xml_ticket = TicketGenerator_TFL_Underground.generateTicket(ticket);
                

            }
         
            
            
            %>
        <textarea rows="4" cols="50">

            <%
                out.print(xml_ticket);
                
                %>
        </textarea>
        <br>
        
  
        
       
        
    </body>
</html>
