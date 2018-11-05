package com.waqar.waqarspringboot.basic.practice;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndPoint {

	@Autowired
	private CourseConfiguration config;

	@Value("${default.course.name}")
	private String defaultCName;
	@Value("${default.course.chapterCount}")
	private int defaultCChapterCount;

	@RequestMapping("/default/course")
	public Course getDefaultEndPoint() {
		return new Course(defaultCName, defaultCChapterCount);
	}

	@RequestMapping("/config/coursemap")
	public HashMap<String, Object> getDefaultConfigEndPoint() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", config.getName());
		map.put("chapterCount", config.getChapterCount());
		map.put("auther", config.getAuther());
		map.put("rating", config.getRating());
		return map;
	}

	@RequestMapping("/course")
	public Course getEndPoint(
			@RequestParam(value = "name", defaultValue = "Spring Boot Udemy", required = false) String name,
			@RequestParam(value = "chapterCount", defaultValue = "4", required = false) int chapterCount) {
		return new Course(name, chapterCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register/course")
	public String saveCourse(@RequestBody Course course) {
		return "Your course named " + course.getName() + " with chapter count " + course.getChapterCount()
				+ " saved successfully";
	}
}
