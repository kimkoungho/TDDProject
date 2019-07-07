package averagestub;

public class AverageService {

	private StudentGradeDAO studentGradeDAO;
	
	
	public Double getAverage(String studentId) {
		StudentGrade studentGrande = studentGradeDAO.getStudentGrade(studentId);
		
		Double average = (studentGrande.getOopGrade() + studentGrande.getFpGrade() + studentGrande.getDbGrade()) / 3.0; 
		return average;
	}


	public void setStudentGradeDAO(StudentGradeDAO studentGradeDAO) {
		this.studentGradeDAO = studentGradeDAO;
	}
	
}
