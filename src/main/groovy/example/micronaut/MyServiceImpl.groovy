package example.micronaut

import groovy.util.logging.Slf4j
import io.micronaut.cache.annotation.Cacheable
import io.micronaut.context.annotation.Primary

import javax.inject.Singleton

@Slf4j
@Primary
@Singleton
@Cacheable // if you comment this out the logging works as expected
class MyServiceImpl implements MyServiceInterface {


    @Override
    void doStuff() {

        log.info("doing stuff")

        def dataA = new Data("A")
        dataA.nestedData = [new Data("ANested1"), new Data("ANested2")]

        def dataB = new Data("B")
        dataB.nestedData = [new Data("BNested1"), new Data("BNested2")]


        def data = [dataA, dataB]

        data.each{ outer ->
            log.info("outer value: " + outer.text)
            outer.nestedData.each{ inner ->
                log.info("inner value: " + inner.text) // This line fails
            }
        }

    }
}
