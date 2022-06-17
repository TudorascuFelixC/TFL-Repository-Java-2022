/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_TFL_Underground;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;





/**
 *
 * @author Tudorascu Felix
 */
@XmlRootElement

public class Ticket {
    private String from_station, to_station, from_zone, to_zone;
    private boolean hasEntered, hasExited;
    private Date  ExpiredDate;



    public Ticket(String from_station, String to_station, String from_zone, String to_zone, boolean hasEntered, boolean hasExited, Date ExpiredDate) {
        this.from_station = from_station;
        this.to_station = to_station;
        this.from_zone = from_zone;
        this.to_zone = to_zone;
        this.hasEntered = hasEntered;
        this.hasExited = hasExited;
        this.ExpiredDate = ExpiredDate;
        
    }

  

    public Ticket() {
    }

    public String getFrom_station() {
        return from_station;
    }

    public void setFrom_station(String from_station) {
        this.from_station = from_station;
    }

    public String getTo_station() {
        return to_station;
    }

    public void setTo_station(String to_station) {
        this.to_station = to_station;
    }

    public String getFrom_zone() {
        return from_zone;
    }

    public void setFrom_zone(String from_zone) {
        this.from_zone = from_zone;
    }

    public String getTo_zone() {
        return to_zone;
    }

    public void setTo_zone(String to_zone) {
        this.to_zone = to_zone;
    }

    public boolean isHasEntered() {
        return hasEntered;
    }

    public void setHasEntered(boolean hasEntered) {
        this.hasEntered = hasEntered;
    }

    public boolean isHasExited() {
        return hasExited;
    }

    public void setHasExited(boolean hasExited) {
        this.hasExited = hasExited;
    }

    
    public Date getExpiredDate() {
        return ExpiredDate;
    }

    public void setExpiredDate(Date ExpiredDate) {
        this.ExpiredDate = ExpiredDate;
    }
    
}