package app.service;

import app.domain.Post;
import app.utils.JDBC;

import java.util.ArrayList;
import java.util.List;

public class Blog {

    private final JDBC jdbc;

    public Blog(JDBC jdbc) {
        this.jdbc = jdbc;
    }

    public List<Post> findAllPostsOfUser(String userName) {
        List<Post> posts = new ArrayList<>();
        for (Post post : jdbc.findAll(Post.class)) {
            if (userName.equals(post.getUser().getName())) {
                posts.add(post);
            }
        }
        return posts;
    }

}
