import play.GlobalSettings;
import play.mvc.Result;
import play.mvc.Http.RequestHeader;

import static play.mvc.Results.*;


public class Global extends GlobalSettings {
    
    @Override
    public Result onHandlerNotFound(RequestHeader arg0) {
        return  notFound(views.html.notFound.render());
    }
}
