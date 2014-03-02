package tutorial.service.support;

import tutorial.domain.MyPost;
import tutorial.service.BlogService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Named;

@Named
public class MockBlogService implements BlogService {

    private static final Random ID_GENERATOR = new Random();
    private Map<Integer, MyPost> posts;

    public MockBlogService() {
        posts = new ConcurrentHashMap<Integer, MyPost>();
        posts.put(100, getHelloWorldPost(100));
    }

    @Override
    public List<MyPost> getPosts() {
        return new ArrayList<MyPost>(posts.values());
    }

    @Override
    public MyPost getPost(int id) {
        return posts.get(id);
    }

    @Override
    public int addPost(MyPost post) {
        int id = ID_GENERATOR.nextInt(1000);
        while (posts.containsKey(id)) {
            id = ID_GENERATOR.nextInt(1000);
        }
        post.setId(id);
        posts.put(id, post);
        return id;
    }

    @Override
    public boolean updatePost(int id, MyPost post) {
        return posts.put(id, post) != null;
    }

    @Override
    public boolean deletePost(int id) {
        return posts.remove(id) != null;
    }

    private MyPost getHelloWorldPost(int id) {
        MyPost post = new MyPost();
        post.setId(id);
        post.setDatePublished(new Date());
        post.setTags(Arrays.asList("hello-world", "example"));
        post.setCategories(Arrays.asList("Java", "Tutorials"));
        post.setTitle("Hello world!");
        post.setContent("This is my first post.");
        return post;
    }
}
