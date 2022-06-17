/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_TFL_Underground;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Tudorascu Felix
 */
public class Gate {
     private int zone;

    public Gate(int zone) {
        this.zone = zone;
    }
     
     public ValidatorTicket enter (String xml){
         
               JAXBContext context;
               ValidatorTicket validatorTicket = new ValidatorTicket();
     
            try{

                   context = JAXBContext.newInstance(Ticket.class);
                   Unmarshaller unmarshaller = context.createUnmarshaller();
                   StringReader reader = new StringReader (xml);
                   Ticket ticket = (Ticket) unmarshaller.unmarshal(reader);
                   if(ticket.isHasEntered() == false && new Date().before(ticket.getExpiredDate()))
                       {
                           ticket.setHasEntered(true);
                           validatorTicket.setIstheticketValid(true);
                       }
            try{
               context = JAXBContext.newInstance(Ticket.class);
              Marshaller marshall = context.createMarshaller();
              StringWriter writer = new StringWriter ();
              marshall.marshal(ticket, writer);
              String re_marshalledXml = writer.toString();
              validatorTicket.setXML(re_marshalledXml);
              return validatorTicket;
            }
                catch (Exception e)
               {
                   System.out.println(e);
               }
    }
        catch (Exception e)
               {
                   System.out.println(e);
               }

                return null;
    }
    public boolean exit(String xml){
                JAXBContext context;
               ValidatorTicket validatorTicket = new ValidatorTicket();
     
            try{

                   context = JAXBContext.newInstance(Ticket.class);
                   Unmarshaller unmarshaller = context.createUnmarshaller();
                   StringReader reader = new StringReader (xml);
                   Ticket ticket = (Ticket) unmarshaller.unmarshal(reader);
                   if(ticket.isHasExited() == false && new Date().before(ticket.getExpiredDate()) && Integer.parseInt(ticket.getTo_zone()) == zone)
                       {
                           ticket.setHasExited(true);
                           return true;
                       }
                      
            }
                   catch(Exception e)
               {
                   System.out.println(e);
               }
                return false;
        }
        }

