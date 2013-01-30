package e2e;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import play.api.libs.ws.Response;
import play.api.libs.ws.WS;

public class AgendaAppTest {
    
    @Test
    public void testNewContactFormPage() {
        running(testServer(3333), new Runnable() {
            
            @Override
            public void run() {
                Response response = WS.url("http://localhost:3333/contact/new").get().await().get();
                String body = response.body();
                assertThat(body).contains("New contact");
            }
        });
    }

}
