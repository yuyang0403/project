package com.libo.po;
/**
 * 实体类
 * @author Administrator
 *
 */
public class News {
	
	public News() {
	}
	public News(String id, String title, String author, String createDate,
			String content) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.createDate = createDate;
		this.content = content;
	}
	private String id;
	private String title;
	private String author;
	private String createDate;
	private String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
