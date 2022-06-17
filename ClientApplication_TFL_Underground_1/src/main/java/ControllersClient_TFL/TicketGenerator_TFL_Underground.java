/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllersClient_TFL;

import Model_TFL_Underground.Ticket;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Tudorascu Felix
 */
public class TicketGenerator_TFL_Underground {

    public static String generateTicket(Ticket ticket){
        
       try{
           JAXBContext context = JAXBContext.newInstance(Ticket.class);
           Marshaller marshall = context.createMarshaller();
           StringWriter writer = new StringWriter();
           marshall.marshal(ticket, writer);
           return writer.toString();
       }
       
       catch(Exception e){
           System.out.println(e);
       }
       return null;
}
    
}
