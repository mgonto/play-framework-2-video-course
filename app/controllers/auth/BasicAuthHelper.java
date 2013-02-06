package controllers.auth;

import play.mvc.Http.Context;

public class BasicAuthHelper {
    
    private static final String AUTHORIZATION = "authorization";
    private static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    private static final String REALM = "Basic realm=\"Agenda app\"";
    
    public static BasicAuthUser auth(Context context) {
        try {
            String authHeader = context.request().getHeader(AUTHORIZATION);
            if (authHeader == null) {
                context.response().setHeader(WWW_AUTHENTICATE, REALM);
                return null;
            }

            String auth = authHeader.substring(6);
            byte[] decodedAuth = new sun.misc.BASE64Decoder().decodeBuffer(auth);
            String[] credString = new String(decodedAuth, "UTF-8").split(":");

            if (credString == null || credString.length != 2) {
                return null;
            }
            
            String username = credString[0];
            String password = credString[1];
            
            return new BasicAuthUser(username, password);
        } catch(Exception ex) {
            return null;
        }
    }
    
    public static class BasicAuthUser {
        public String name;
        public String password;
        protected BasicAuthUser(String name, String password) {
            this.name = name;
            this.password = password;
        }
        
        
    }

}
