package com.firozkhan.blogging.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.firozkhan.blogging.model.Blog;
import com.firozkhan.blogging.service.BlogService;

@Controller
public class BlogResolver {

    private final BlogService blogService;

    public BlogResolver(BlogService blogService) {
        this.blogService = blogService;
    }

    @QueryMapping
    public List<Blog> getAllBlog() {
        return blogService.getAll();
    }

    @QueryMapping
    public Blog getBlogById(@Argument String id) {
        return (blogService.getById(id));
    }

    @MutationMapping
    public Blog createBlog(@Argument String title, @Argument String content, @Argument String author) {
        return (blogService.create(title, content, author));
    }

    @MutationMapping
    public Boolean deleteBlog(@Argument String id) {
        return blogService.delete(id);
    }

    @MutationMapping
    public Blog updateBlog(@Argument String id, @Argument String title, @Argument String content,
            @Argument String author) {
        return (blogService.update(id, title, content, author));
    }
}
