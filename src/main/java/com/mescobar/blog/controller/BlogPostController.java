package com.mescobar.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mescobar.blog.model.BlogPost;
import com.mescobar.blog.service.BlogPostService;

@RestController
@RequestMapping("v1/posts")
public class BlogPostController {

	private final BlogPostService blogPostService;

	@Autowired
	public BlogPostController(BlogPostService blogPostService) {
		this.blogPostService = blogPostService;
	}

	@GetMapping
	public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
		return new ResponseEntity<>(blogPostService.getAllBlogPosts(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
		BlogPost blogPost = blogPostService.getBlogPostById(id);
		if (blogPost != null) {
			return new ResponseEntity<>(blogPost, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping
	public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
		return new ResponseEntity<>(blogPostService.createBlogPost(blogPost));
	}

	@PutMapping("{id}")
	public ResponseEntity<BlogPost> updateBlogPostById(@PathVariable Long id, @RequestBody BlogPost blogPost) {
		return new ResponseEntity<>(blogPostService.updateBlogPostById(id, blogPost));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<BlogPost> deleteBlogPostById(@PathVariable Long id) {
		return new ResponseEntity<>(blogPostService.deletePostById(id));
	}
}
