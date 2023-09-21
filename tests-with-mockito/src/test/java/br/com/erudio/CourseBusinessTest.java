package br.com.erudio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.erudio.service.CourseService;
import br.com.erudio.service.stub.CourseServiceStub;

class CourseBusinessTest {

	
	@Test
	void testCoursesRelatedToSpring_When_UsingAStub() {
		//Given / Arrange
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		
		//When / Act
		var filteredCourses = business.retrieveCourseRelatedToSpring("Jonas");
		
		//Then / Assert
		assertEquals(4, filteredCourses.size());
		
	}
	@Test
	void testCoursesRelatedToSpring_When_UsingAFooBarStudent() {
		//Given / Arrange
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		
		//When / Act
		var filteredCourses = business.retrieveCourseRelatedToSpring("Foo Bar");
		
		//Then / Assert
		assertEquals(4, filteredCourses.size());
		
	}
}
