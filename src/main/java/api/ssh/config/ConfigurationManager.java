package test.api.ssh.config;

import org.aeonbits.owner.ConfigCache;

public interface ConfigurationManager {

    Configuration configuration = ConfigCache.getOrCreate(Configuration.class);

}
