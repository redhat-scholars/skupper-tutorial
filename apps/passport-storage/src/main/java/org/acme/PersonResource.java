package org.acme;

import io.quarkus.runtime.Startup;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


import java.util.List;
import java.util.Map;

@Path("/person")
public class PersonResource {

    @Startup
    @Transactional
    public void createPersons() {
      Person p1 = new Person();
      p1.name = "Alex";
      p1.surname = "Soto";
      
      p1.persist();
      
      Person p2 = new Person();
      p2.name = "Natale";
      p2.surname  = "Vinto";
      
      p2.persist();
      
    }
  
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> allPersons() {
      return Person.listAll();
    }
}
