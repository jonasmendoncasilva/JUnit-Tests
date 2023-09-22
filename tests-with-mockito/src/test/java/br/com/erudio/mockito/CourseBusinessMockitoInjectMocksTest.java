package br.com.erudio.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.erudio.CourseBusiness;
import br.com.erudio.service.CourseService;

@ExtendWith(MockitoExtension.class)
class CourseBusinessMockitoInjectMocksTest {
	
	@Mock
	CourseService mockService;
	
	@InjectMocks
	CourseBusiness business; //business = new CourseBusiness(mockService);
	
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	
	List<String> courses;
	
	@BeforeEach		
	void setup() {
		
		//Given / Arrange
		
		
	
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
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
	}
			
	@DisplayName("Delete Courses not Related Spring using Mockito Capturing Arguments should  call Method deleteCourse")
	@Test
	void testDeleteCoursesNotRelatedToSpring_CapturingArguments_Should_CallMethod_deleteCourse() {
		
		//Given / Arrange
		given(mockService.retrieveCourses("Jonas")).willReturn(courses);
		
		//ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		
		
		//When / Act
		business.deleteCoursesNotRelatedToSpring("Jonas");
		
		//Then / Assert
		then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());	
		assertThat(argumentCaptor.getAllValues().size(), is(7));
	}
}
