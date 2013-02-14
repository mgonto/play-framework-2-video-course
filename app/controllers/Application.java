package controllers;

import play.*;
import play.libs.WS;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
      return redirect(routes.Agenda.list());
  }
  
}