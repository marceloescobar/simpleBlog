package com.mescobar.blog.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class BlogPost {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String text;
	private String created;
	private String updated;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "blog_post_category",
	        joinColumns = {@JoinColumn(name = "blog_post_id")},
	        inverseJoinColumns = {@JoinColumn(name = "blog_post_category_id")}
	)
	@JsonProperty("blog_categories")
	public List<BlogCategory> blogCategories;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "blog_post_tag",
	        joinColumns = {@JoinColumn(name = "blog_post_id")},
	        inverseJoinColumns = {@JoinColumn(name = "blog_post_tag_id")}
	)
	@JsonProperty("blog_tags")
	public List<BlogTag> blogTags;
	
	 @JsonGetter("blog_categories")
	    public List<String> getAllWalletPlatforms() {
	        if(blogCategories != null) {
	            return blogCategories.stream()
	                    .map(bc -> {
	                        return "/v1/categories/" + bc.getId();
	                    }).collect(Collectors.toList());
	        }
	        return null;
	    }
	 
	  @JsonGetter("blog_tags")
	    public List<String> getAllWalletStorages() {
	        if(blogTags != null) {
	            return blogTags.stream()
	                    .map(bt -> {
	                        return "/v1/tags/" + bt.getId();
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

}
