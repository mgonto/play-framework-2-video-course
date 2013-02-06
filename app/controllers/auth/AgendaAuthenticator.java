package controllers.auth;

import controllers.auth.BasicAuthHelper.BasicAuthUser;
import play.mvc.Http.Context;
import play.mvc.Security.Authenticator;

public class AgendaAuthenticator extends Authenticator {
    
    @Override
    public String getUsername(Context context) {
        BasicAuthUser basicAuthUser = BasicAuthHelper.auth(context);
        if (basicAuthUser == null) {
            return null;
        }
        
        if (basicAuthUser.name.equals("mgonto") && basicAuthUser.password.equals("mgonto")) {
            return basicAuthUser.name;
        } else {
            return null;
        }
    }

}
