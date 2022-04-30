package test.api.covenant;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import test.api.covenant.config.ConfigurationManager;

public class CovenantEndpointSpec implements ConfigurationManager {

    static RequestSpecification set () {
        return new RequestSpecBuilder().
                setBaseUri(configuration.url()).
                setBasePath(configuration.path()).
                setPort(configuration.port()).
                //setContentType(ContentType.JSON).
                setRelaxedHTTPSValidation().
                build().
                given();

    }
}
