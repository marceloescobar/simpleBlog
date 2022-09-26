package com.mescobar.blog.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
public class BlogCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	 @ManyToMany(mappedBy="blogCategories")
	    List<BlogPost> blogPosts;

	    @JsonGetter("blogPosts")
	    public List<String> getAllBlogPosts() {
	        if (blogPosts != null) {
	            return blogPosts.stream()
	                    .map(bp -> {
	                        return "/v1/posts/" + bp.getId();
	                    }).collect(Collectors.toList());
	        }
	        return null;
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
