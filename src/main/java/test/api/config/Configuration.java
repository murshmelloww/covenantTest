package test.api.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api.properties"
})
public interface Configuration extends Config {

    @Key("api.path")
    String path();
    @Key("api.url")
    String url();
    @Key("api.port")
    Integer port();
    @Key("password")
    String password();
    @Key("username")
    String username();
}
