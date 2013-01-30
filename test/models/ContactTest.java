package models;

import static org.junit.Assert.*;

import org.junit.Test;

import play.mvc.Result;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class ContactTest {

    @Test
    public void testContact() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            @Override
            public void run() {
                
                Contact contact = new Contact();
                contact.name = "Martin Gontovnikas";
                contact.phone = "555111222";
                contact.email = "g@g.com";
                
                contact.save();
                
                Contact contactFromDb = contact.find.byId(contact.id);
                
                assertThat(contactFromDb).isNotNull();
                
                assertThat(contactFromDb.name).isEqualTo(contact.name);
            }
        });
    }
    

}
