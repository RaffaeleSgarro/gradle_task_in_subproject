package app.service;

import app.utils.JDBC;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BlogTest {
    @Test
    public void testFindAllPostsOfUser() throws Exception {
        JDBC jdbc = new JDBC();
        Blog target = new Blog(jdbc);
        assertTrue(target.findAllPostsOfUser("mark").isEmpty());
    }
}