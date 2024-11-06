package com.firozkhan.blogging.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.firozkhan.blogging.model.Blog;
import com.firozkhan.blogging.repository.BlogRepository;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    public Blog getById(String id) {
        return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog Not Found by Id: " + id));
    }

    public Blog create(String title, String content, String author) {
        Blog blog = new Blog(title, content, author);
        return blogRepository.save(blog);
    }

    public Boolean delete(String id) {
        blogRepository.deleteById(id);
        return !(blogRepository.existsById(id));
    }

    public Blog update(String id, String title, String content, String author) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog Not Found By Id" + id));
        blog.setTitle(title);
        blog.setContent(content);
        blog.setAuthor(author);
        return blogRepository.save(blog);
    }

}
