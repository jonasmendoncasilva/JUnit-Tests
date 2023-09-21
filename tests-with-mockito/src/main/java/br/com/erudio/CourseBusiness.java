package br.com.erudio;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.service.CourseService;

//System Under Test
public class CourseBusiness {

	//Course service é uma dependência
	private CourseService service;

	public CourseBusiness(CourseService service) {
		this.service = service;
	}

	public List<String> retrieveCourseRelatedToSpring(String student){
		
		var filteredCourses = new ArrayList<String>();
		if("Foo Bar".equals(student)) return filteredCourses;
		var allCourses = service.retrieveCourses(student);
		
		for (String course : allCourses) {
			if(course.contains("Spring")) {
				filteredCourses.add(course);
			}
		}
		
		return filteredCourses;
	}
	
}
