package com.jsa.news.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "noticias")
public class Noticia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private boolean featured;
	private String image_url;
	private String news_site;
	private String published_at;
	@Lob
    @Column(name = "summary", length = 4096)
	private String summary;
	private String title;
	private String updated_at;
	private String url;	
	
	public Noticia() {}

	public Noticia(boolean featured, String image_url, String news_site, String published_at, String summary,
			String title, String updated_at, String url) {
		super();
		this.featured = featured;
		this.image_url = image_url;
		this.news_site = news_site;
		this.published_at = published_at;
		this.summary = summary;
		this.title = title;
		this.updated_at = updated_at;
		this.url = url;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getNews_site() {
		return news_site;
	}

	public void setNews_site(String news_site) {
		this.news_site = news_site;
	}

	public String getPublished_at() {
		return published_at;
	}

	public void setPublished_at(String published_at) {
		this.published_at = published_at;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", featured=" + featured + ", image_url=" + image_url + ", news_site=" + news_site
				+ ", published_at=" + published_at + ", summary=" + summary + ", title=" + title + ", updated_at="
				+ updated_at + ", url=" + url + "]";
	}

}
