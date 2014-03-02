package tutorial.provider.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import tutorial.provider.support.BlogRestfulServiceV1;
import tutorial.provider.support.BlogRestfulServiceV2;

/**
 *
 * @author Nazar Annagurban
 */
public class AppConfig extends ResourceConfig {

    public AppConfig() {
        register(BlogRestfulServiceV1.class);
        register(BlogRestfulServiceV2.class);
    }
}
