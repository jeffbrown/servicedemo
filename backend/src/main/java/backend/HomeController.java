package backend;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.runtime.server.EmbeddedServer;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    private final EmbeddedServer embeddedServer;

    public HomeController(EmbeddedServer embeddedServer) {
        this.embeddedServer = embeddedServer;
    }

    @Get("/")
    public Map info() {
        Map m = new HashMap();

        String host = embeddedServer.getHost();
        int port = embeddedServer.getPort();

        m.put("host", host);
        m.put("port", port);
        return m;
    }
}
