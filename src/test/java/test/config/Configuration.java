package test.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api.properties"
})
public interface Configuration extends Config {

    @Config.Key("userName")
    String userName();
    @Config.Key("admin.password")
    String adminPassword();
    @Config.Key("user.password")
    String userPassword();
    @Config.Key("admin.name")
    String adminName();

    @Config.Key("base.path")
    String basePath();

}
