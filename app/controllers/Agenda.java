package controllers;

import java.util.List;

import models.Contact;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Agenda extends Controller {
    
    public static Result list() {
        List<Contact> contacts = Contact.find.all();
        return ok(views.html.list.render(contacts));
    }
    
    public static Result show(Long id) {
        Contact contact = Contact.find.byId(id);
        if (contact == null) {
            return notFound();
        } else {
            return ok(views.html.show.render(contact));
        }
    }
    
    public static Result newContact() {
        Form<Contact> contactForm = form(Contact.class);
        return ok(views.html.newContact.render(contactForm));
    }
    
    public static Result createContact() {
        Form<Contact> contactForm = form(Contact.class).bindFromRequest();
        Contact contact = contactForm.get();
        contact.save();
        return redirect(routes.Agenda.list());
    }

}
