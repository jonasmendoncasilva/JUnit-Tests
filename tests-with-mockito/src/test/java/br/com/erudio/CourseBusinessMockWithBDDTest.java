package br.com.erudio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.erudio.service.CourseService;

class CourseBusinessMockWithBDDTest {

	CourseService mockService;
	CourseBusiness business;
	List<String> courses;
	
	@BeforeEach		
	void setup() {
		//Given / Arrange
		mockService = mock(CourseService.class);
		business = new CourseBusiness(mockService);
	
		courses = Arrays.asList(
				"REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker");;
	}
			
	@Test
	void testCoursesRelatedToSpring_When_UsingAStub() {
		
		//Given / Arrange
		given(mockService.retrieveCourses("Jonas")).willReturn(courses);
		
		//When / Act
		var filteredCourses = business.retrieveCourseRelatedToSpring("Jonas");
		
		//Then / Assert
		assertThat(filteredCourses.size(), is(4));
		
	}
	
	@DisplayName("Delete Courses not Related Spring using Mockito should call Method deleteCourse")
	@Test
	void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCourse() {
		
		//Given / Arrange
		given(mockService.retrieveCourses("Jonas")).willReturn(courses);
		
		//When / Act
		business.deleteCoursesNotRelatedToSpring("Jonas");
		
		//Then / Assert
		verify(mockService).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		
	}
}
