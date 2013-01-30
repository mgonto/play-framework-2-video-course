package views;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import models.Contact;

import org.junit.Test;

import play.api.templates.Html;

public class ListTemplateTest {
    
    @Test
    public void testTemplateList() {
        List<Contact> contacts = new ArrayList<Contact>();
        Contact contact = new Contact();
        contact.name = "Martin Gontovnikas";
        contact.phone = "555111222";
        contact.email = "g@g.com";
        contacts.add(contact);
        Html content = views.html.list.render(contacts);
        
        assertThat(contentType(content)).isEqualTo("text/html");
        
        assertThat(contentAsString(content)).contains(contact.name);
        assertThat(contentAsString(content)).contains("Create new one");
        
    }

}
