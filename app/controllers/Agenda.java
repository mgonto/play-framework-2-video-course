package controllers;

import java.util.List;

import models.Contact;
import play.mvc.Controller;
import play.mvc.Result;

public class Agenda extends Controller {
    
    public static Result list() {
        List<Contact> contacts = Contact.find.all();
        return ok();
    }
    
    public static Result show(Long id) {
        Contact contact = Contact.find.byId(id);
        if (contact == null) {
            return notFound();
        } else {
            return ok();
        }
    }

}
