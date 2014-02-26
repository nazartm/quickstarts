package tutorial.provider.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import tutorial.provider.jaxrs.DefaultBlogService;

/**
 *
 * @author Nazar Annagurban
 */
public class AppConfig extends ResourceConfig {

    public AppConfig() {
        register(DefaultBlogService.class);
    }
}
