package controllers;

import static org.junit.Assert.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import models.Contact;

import org.junit.Test;

import play.mvc.Result;

public class AgendaTest {

    @Test
    public void testListAction() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            
            @Override
            public void run() {
                Contact contact = new Contact();
                contact.name = "Martin Gontovnikas";
                contact.phone = "555111222";
                contact.email = "g@g.com";
                
                contact.save();
                
                Result result = callAction(controllers.routes.ref.Agenda.list());
                
                assertThat(status(result)).isEqualTo(OK);
                assertThat(contentType(result)).isEqualTo("text/html");
                assertThat(contentAsString(result)).contains(contact.name);
                
            }
        });
    }
    
    @Test
    public void testNewContactRoute() {
        Result result = routeAndCall(fakeRequest(GET, "/contact/new"));
        assertThat(status(result)).isEqualTo(OK);
    }
    
    @Test
    public void testInvalidRoute() {
        Result result = routeAndCall(fakeRequest(GET, "/concon/tact"));
        assertThat(result).isNull();
    }
}
