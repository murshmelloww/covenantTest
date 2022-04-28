package api.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CovenantEndpointSpec implements ConfigurationManager {

    static RequestSpecification set () {
        return new RequestSpecBuilder().
                setBaseUri(configuration.url()).
                setBasePath(configuration.path()).
                setPort(configuration.port()).
                //setContentType(ContentType.JSON).
                setRelaxedHTTPSValidation().
                build().
                log().all().
                given();

    }
}
