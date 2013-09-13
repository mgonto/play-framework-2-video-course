package controllers;

import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import models.Contact;
import play.data.Form;
import static play.data.Form.form;
import play.mvc.BodyParser;
import play.mvc.BodyParser.Json;
import play.mvc.Controller;
import play.mvc.Result;

//@Authenticated(AgendaAuthenticator.class)
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
    
    @BodyParser.Of(Json.class)
    public static Result createContactJson() {
        JsonNode json = request().body().asJson();
        ObjectNode result = play.libs.Json.newObject();
        String name = json.findPath("name").getTextValue();
        String phone = json.findPath("phone").getTextValue();
        String email = json.findPath("email").getTextValue();
        if (name == null || phone == null || email == null) {
            result.put("status", "fail");
            return badRequest(result);
        } else {
            Contact contact = new Contact();
            contact.name = name;
            contact.phone = phone;
            contact.email = email;
            contact.save();
            result.put("status", "OK");
            return ok(result);
        }
    }
    
    public static Result createContact() {
        Form<Contact> contactForm = form(Contact.class).bindFromRequest();
        if (contactForm.hasErrors()) {
            return badRequest(views.html.newContact.render(contactForm));
        } else {
            Contact contact = contactForm.get();
            contact.save();
            return redirect(routes.Agenda.list());
        }
    }

}
