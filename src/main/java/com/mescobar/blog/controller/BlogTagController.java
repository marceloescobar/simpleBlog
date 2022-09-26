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

import com.mescobar.blog.model.BlogTag;
import com.mescobar.blog.service.BlogTagService;

@RestController
@RequestMapping("v1/tags")
public class BlogTagController {

	private final BlogTagService blogTagService;

	@Autowired
	public BlogTagController(BlogTagService blogTagService) {
		this.blogTagService = blogTagService;
	}

	@GetMapping
	public ResponseEntity<List<BlogTag>> getAllBlogTags() {
		return new ResponseEntity<>(blogTagService.getAllBlogTags(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<BlogTag> getBlogTagById(@PathVariable Long id) {
		BlogTag blogTag = blogTagService.getBlogTagById(id);
		if (blogTag != null) {
			return new ResponseEntity<>(blogTag, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping
	public ResponseEntity<BlogTag> createBlogTag(@RequestBody BlogTag blogTag) {
		blogTagService.createBlogTag(blogTag);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<BlogTag> updateBlogTagById(@PathVariable Long id, @RequestBody BlogTag blogTag) {
		return new ResponseEntity<>(blogTagService.updateBlogTagById(id, blogTag));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<BlogTag> deleteBlogTagById(@PathVariable Long id) {
		return new ResponseEntity<>(blogTagService.deleteTagById(id));
	}
}
