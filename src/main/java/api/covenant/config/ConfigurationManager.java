package test.api.covenant.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigCache;

public interface ConfigurationManager {

    Configuration configuration = ConfigCache.getOrCreate(Configuration.class);

    static RequestSpecification set ()
    {
        return new RequestSpecBuilder().
                build();
    }
}
