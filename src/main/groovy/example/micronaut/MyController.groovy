package example.micronaut

import groovy.util.logging.Slf4j
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

import javax.inject.Inject

@Slf4j
@Controller("/hello")
class MyController {

    @Inject
    MyServiceInterface myServiceInterface

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    String index() {
        myServiceInterface.doStuff()
        return "Hello World"
    }
}