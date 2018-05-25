package server;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.Client;

import java.util.Map;

@Client("backend")
public interface BackendClient {

    @Get("/home")
    Map info();
}
