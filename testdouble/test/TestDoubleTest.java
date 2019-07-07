package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import averagestub.AverageService;
import averagestub.StudentGrade;
import averagestub.StudentGradeDAO;
import securitymock.Door;
import securitymock.SecurityService;
import securitymock.Window;

@RunWith(MockitoJUnitRunner.class)
public class TestDoubleTest {

	@Test
	public void averageServiceStubTest() {
		/** set up */
		// dependency object
		StudentGradeDAO studentGradeDAO = mock(StudentGradeDAO.class);
		// test target
		AverageService averageService = new AverageService();
		// inject
		averageService.setStudentGradeDAO(studentGradeDAO);
		
		/** given */
		String studentId = "testId";
		StudentGrade studentGrade = new StudentGrade(8d, 6d, 10d);
		
		// stubbing
	    when(studentGradeDAO.getStudentGrade(studentId))
	      	.thenReturn(studentGrade);
	    
	    // exercise
	    Double average = averageService.getAverage(studentId);
	    
	    // verify
	    Double expect = (8 + 6 + 10) / 3.0;
	    Assert.assertEquals(expect, average);
	    
//	    System.out.println(average);
	}
	
	@Test
	public void securityServiceMockTest() {
		/** set up */
		// dependency object
		Window windowMock = mock(Window.class);
		Door doorMock = mock(Door.class);
		// test target
		SecurityService securityService = new SecurityService(windowMock, doorMock);
		
		// exercise
		securityService.securityOn();

		// verify : door.close()
		verify(doorMock).close();
		verify(windowMock, never()).close();
	}
	
	@Test
	public void listSpyTest() {
		// spy
		List list = spy(List.class);
		
		// stubing
		when(list.size())
			.thenReturn(-1);
		
		list.add("123");
		
		// size 에 대해서 stubing 해서 size 가 음수 
		Assert.assertEquals(-1, list.size());
	}
}
