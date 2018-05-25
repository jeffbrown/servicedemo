package server;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Map;

@Controller
public class HomeController {

    private BackendClient backendClient;

    public HomeController(BackendClient backendClient) {
        this.backendClient = backendClient;
    }
    @Get("/")
    public Map index() {
        return backendClient.info();
    }
}
