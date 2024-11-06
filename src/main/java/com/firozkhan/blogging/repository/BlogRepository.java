package com.firozkhan.blogging.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.firozkhan.blogging.model.Blog;

@Repository
public interface BlogRepository extends MongoRepository<Blog, String> {

}
