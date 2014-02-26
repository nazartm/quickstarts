package tutorial.provider.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import tutorial.provider.jaxrs.DefaultBlogRestfulService;

/**
 *
 * @author Nazar Annagurban
 */
public class AppConfig extends ResourceConfig {

    public AppConfig() {
        register(DefaultBlogRestfulService.class);
    }
}
