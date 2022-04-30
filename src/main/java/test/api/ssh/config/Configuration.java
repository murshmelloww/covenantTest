package test.api.ssh.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api.properties"
})
public interface Configuration extends Config {

    @Key("remote.host")
    String host();
    @Key("remote.port")
    Integer port();
    @Key("remote.password")
    String password();
    @Key("remote.username")
    String username();
}
