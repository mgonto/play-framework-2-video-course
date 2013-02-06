package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Pattern;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Contact extends Model {
    
    @Id
    @GeneratedValue
    public Long id;
    
    @Required
    public String name;
    
    @Required
    public String phone;

    @Required
    @Email
    public String email;
    
    public static Finder<Long, Contact> find = new Finder<Long, Contact>(Long.class, Contact.class);

}
