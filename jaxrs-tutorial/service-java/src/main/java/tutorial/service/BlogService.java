package tutorial.service;

import tutorial.domain.MyPost;
import java.util.List;

/**
 * Business service interface.
 */
public interface BlogService {

    List<MyPost> getPosts();

    MyPost getPost(int id);

    int addPost(MyPost post);

    boolean updatePost(int id, MyPost post);

    boolean deletePost(int id);
}
