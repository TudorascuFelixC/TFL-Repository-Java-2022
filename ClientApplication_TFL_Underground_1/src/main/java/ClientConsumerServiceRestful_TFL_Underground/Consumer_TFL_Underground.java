/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientConsumerServiceRestful_TFL_Underground;


import Model_TFL_Underground.Station;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @Tudorascu Felix
 */
public class Consumer_TFL_Underground {
    

    
    public static List<Station> getStations() {


        Client client = ClientBuilder.newBuilder().build();

                                          
        WebTarget target = client.target("http://localhost:8080/ResTWebService_TFL_Underground/resources/Facade.Stations");
        
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_XML);
        
        Response response = invocation.get();
        
        List<Station> stationList;
        stationList = response.readEntity(new GenericType<List<Station>>(){});
        
        return stationList;
        
    }
    
    public static void main(String[] aregs)
    {
        List<Station> st = getStations();
        for(int i=0;i<st.size();i++)
        {
            System.out.println(st.get(i).getStationname());
        }
                
    }
    
}
