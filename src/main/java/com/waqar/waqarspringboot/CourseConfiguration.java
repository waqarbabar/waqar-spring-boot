package com.waqar.waqarspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("course")
public class CourseConfiguration {
	
	private String name;
	private int chapterCount;
	private int rating;
	private String auther;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChapterCount() {
		return chapterCount;
	}

	public void setChapterCount(int chapterCount) {
		this.chapterCount = chapterCount;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

}
