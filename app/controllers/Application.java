package controllers;

import play.libs.F.Function;
import play.libs.WS;
import play.libs.WS.Response;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
  
  public static Result index() {
      return redirect(routes.Agenda.list());
  }
  
  public static Result externalWs() {
      return async(WS.url("http://search.twitter.com/search.json").setQueryParameter("q", "mgonto").get().map(new Function<WS.Response, Result>() {

        @Override
        public Result apply(Response response) throws Throwable {
            return ok(response.asJson().findPath("max_id"));
        }
    }));
  }
  
}