package com.mescobar.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mescobar.blog.model.BlogTag;

@Repository
public interface BlogTagRepository extends JpaRepository<BlogTag, Long> {

}
