package api.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigCache;

public interface ConfigurationManager {

    Configuration configuration = ConfigCache.getOrCreate(Configuration.class);

    public static RequestSpecification set ()
    {
        return new RequestSpecBuilder().
                build();
    }
}
