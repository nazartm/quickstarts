package tutorial.provider.jaxrs;

import tutorial.jaxrs.entity.Post;
import tutorial.jaxrs.service.BlogRestfulService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import tutorial.domain.MyPost;
import tutorial.service.BlogService;

@Named
@Scope("request")
public class DefaultBlogService implements BlogRestfulService {

    private BlogService service;
    private Mapper mapper;

    @Autowired
    public DefaultBlogService(BlogService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public List<Post> getPosts() {
        List<MyPost> posts = service.getPosts();
        List<Post> dtoPosts = new ArrayList<Post>(posts.size());
        for (MyPost myPost : posts) {
            dtoPosts.add(mapper.map(myPost, Post.class));
        }
        return dtoPosts;
    }

    @Override
    public Post getPost(int id) {
        MyPost post = service.getPost(id);
        if (post == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return mapper.map(post, Post.class);
    }

    @Override
    public Response addPost(Post post) {
        int id = service.addPost(mapper.map(post, MyPost.class));
        return Response.created(UriBuilder.fromPath(Integer.toString(id)).build()).build();
    }

    @Override
    public Response updatePost(int id, Post post) {
        boolean success = service.updatePost(id, mapper.map(post, MyPost.class));
        if (!success) {
            throw new WebApplicationException(Response.Status.NOT_MODIFIED);
        }
        return Response.ok().build();
    }

    @Override
    public Response deletePost(int id) {
        boolean success = service.deletePost(id);
        if (!success) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok().build();
    }
}