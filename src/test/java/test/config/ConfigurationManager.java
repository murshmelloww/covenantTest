package test.config;

import org.aeonbits.owner.ConfigCache;

public interface ConfigurationManager {

    Configuration configuration = ConfigCache.getOrCreate(Configuration.class);

}
